package br.com.UWBike.service;

import br.com.UWBike.dto.FuncionarioRequestDto;

import br.com.UWBike.exceptions.IdNaoEncontradoException;
import br.com.UWBike.model.Funcionario;

import br.com.UWBike.model.Login;
import br.com.UWBike.model.Patio;
import br.com.UWBike.repository.FuncionarioRepository;
import br.com.UWBike.repository.PatioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Optional;



@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PatioRepository patioRepository;

    public Funcionario salvarFuncionario(FuncionarioRequestDto dto) throws Exception {
        String insertFuncionario = """
            INSERT INTO tb_funcionario (id_funcionario, nome_func, cpf, salario, cargo)
            VALUES (tb_funcionario_seq.NEXTVAL, ?, ?, ?, ?)
        """;

        String insertLogin = """
            INSERT INTO tb_login (id_funcionario, login, senha)
            VALUES (?, ?, ?)
        """;

        String insertPatio = """
            INSERT INTO tb_patio_funcionario (id_patio, id_funcionario)
            VALUES (?, ?)
        """;

        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);


            Long idFuncionario = null;
            try (PreparedStatement ps = conn.prepareStatement(insertFuncionario, new String[]{"id_funcionario"})) {
                ps.setString(1, dto.getNomeFunc());
                ps.setString(2, dto.getCpf());
                ps.setDouble(3, dto.getSalario());
                ps.setString(4, dto.getCargo());
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        idFuncionario = rs.getLong(1);
                    }
                }
            }

            if (idFuncionario == null) {
                conn.rollback();
                throw new SQLException("Falha ao gerar ID do funcionário");
            }


            try (PreparedStatement ps = conn.prepareStatement(insertLogin)) {
                ps.setLong(1, idFuncionario);
                ps.setString(2, dto.getLogin().getLogin());
                ps.setString(3, passwordEncoder.encode(dto.getLogin().getSenha()));
                ps.executeUpdate();
            }


            if (dto.getIdPatio() != 0) {
                try (PreparedStatement ps = conn.prepareStatement(insertPatio)) {
                    ps.setLong(1, dto.getIdPatio());
                    ps.setLong(2, idFuncionario);
                    ps.executeUpdate();
                }
            }

            conn.commit();

            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(idFuncionario);
            funcionario.setNomeFunc(dto.getNomeFunc());
            funcionario.setCpf(dto.getCpf());
            funcionario.setSalario(dto.getSalario());
            funcionario.setCargo(dto.getCargo());

            return funcionario;
        }
    }

    @Transactional
    public void removerFuncionario(Long id) throws IdNaoEncontradoException {
        Funcionario funcionarioAchado = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Funcionario não encontrada"));

        funcionarioRepository.delete(funcionarioAchado);


        System.out.println("Funcionario: " + funcionarioAchado.getNomeFunc() + ", " + funcionarioAchado.getCpf() + " deletado com sucesso!");

    }

    @Transactional
    public void atualizarDadosFuncionario(Long id, Funcionario funcionario) throws IdNaoEncontradoException{
        Funcionario funcionarioAchado = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Funcionario não encontrado"));

        funcionarioAchado.setCargo(funcionario.getCargo());
        funcionarioAchado.setSalario(funcionario.getSalario());

        System.out.println("Funcionario: " + funcionarioAchado.getNomeFunc() + ", " + funcionario.getCpf()
                + "teve seu salário atualizado com sucesso para: " + funcionario.getSalario() );

    }

    public Optional<Funcionario> visualizarDadosFuncionarioEspecifico(Long id) {
        return funcionarioRepository.findById(id);
    }

    //função para converter os valores das senhas inseridas manualmente no banco para senhas criptografadas
    @Transactional
    public void atualizarSenhasParaBCrypt() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        for (Funcionario f : funcionarios) {
            Login login = f.getLogin();
            if (login != null) {
                String senha = login.getSenha();


                if (!senha.startsWith("$2a$") && !senha.startsWith("$2b$")) {
                    String senhaCriptografada = passwordEncoder.encode(senha);
                    login.setSenha(senhaCriptografada);
                    System.out.println("Senha do login " + login.getLogin() + " atualizada para BCrypt.");
                }
            }
        }

        funcionarioRepository.saveAll(funcionarios);
    }

    public Optional<Funcionario> buscarPorLogin(String login) {
        return funcionarioRepository.findByLogin_Login(login);
    }
    public List<Patio> listarFuncionariosPorPatio() {
        return patioRepository.findAll();
    }
    
}
