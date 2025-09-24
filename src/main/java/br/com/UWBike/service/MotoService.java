package br.com.UWBike.service;


import br.com.UWBike.exceptions.IdNaoEncontradoException;

import br.com.UWBike.model.Moto;

import br.com.UWBike.repository.FuncionarioRepository;

import br.com.UWBike.repository.MotoRepository;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MotoService {


    @Autowired
    private MotoRepository motoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private MotoPatioService motoPatioService;
    @Autowired
    private DataSource dataSource;

    public Moto salvarMoto(Moto moto, Long idFuncionario) {
        String sqlInsertMoto = "INSERT INTO tb_moto (modelo, placa, chassi) VALUES (?, ?, ?)";
        String sqlGetPatioFuncionario = "SELECT p.id_patio " +
                "FROM tb_funcionario f " +
                "JOIN tb_patio_funcionario fp ON f.id_funcionario = fp.id_funcionario " +
                "JOIN tb_patio p ON fp.id_patio = p.id_patio " +
                "WHERE f.id_funcionario = ?";

        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            Long idMoto;

            try (PreparedStatement ps = conn.prepareStatement(sqlInsertMoto, new String[]{"id_moto"})) {
                ps.setString(1, moto.getModelo());
                ps.setString(2, moto.getPlaca());
                ps.setString(3, moto.getChassi());
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        idMoto = rs.getLong(1);
                    } else {
                        throw new SQLException("Erro ao obter ID da moto inserida.");
                    }
                }
            }

            Long idPatio;
            try (PreparedStatement ps = conn.prepareStatement(sqlGetPatioFuncionario)) {
                ps.setLong(1, idFuncionario);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idPatio = rs.getLong("id_patio");
                    } else {
                        throw new IdNaoEncontradoException("Funcionário não está vinculado a nenhum pátio.");
                    }
                }
            }


            String sqlInsertMotoPatio = "INSERT INTO tb_moto_patio (id_moto, id_patio, data_hora_entrada) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sqlInsertMotoPatio)) {
                ps.setLong(1, idMoto);
                ps.setLong(2, idPatio);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.executeUpdate();
            }

            conn.commit();
            System.out.println("Moto cadastrada e vinculada ao pátio com sucesso!");
            moto.setId_moto(idMoto);
            return moto;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Houve um erro ao tentar cadastrar a moto");
            return null;
        }
    }


    public void removerMoto(Long id) throws IdNaoEncontradoException {
        Moto motoAchada = motoRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));

                motoRepository.deleteById(id);

            System.out.println("Moto: " + motoAchada.getId_moto() + ", " + motoAchada.getPlaca() + " deletada com sucesso!");

    }

    @Transactional
    public void atualizarDadosMoto(Long id, Moto moto) throws IdNaoEncontradoException{
        Moto motoAchada = motoRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));

        motoAchada.setPlaca(moto.getPlaca());

        System.out.println("Moto: " + motoAchada.getId_moto() + ", "
                + " atualizada com sucesso para: " + moto.getPlaca() + " " + moto.getModelo());

    }

    public Optional<Moto> visualizarDadosMotoEspecifica(Long id) {
      return motoRepository.findById(id);

    }


}
