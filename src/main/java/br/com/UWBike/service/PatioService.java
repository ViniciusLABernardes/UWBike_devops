package br.com.UWBike.service;


import br.com.UWBike.exceptions.IdNaoEncontradoException;

import br.com.UWBike.model.Patio;
import br.com.UWBike.repository.PatioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    public Patio salvarPatio(Patio patio) {
        try {

            System.out.println("Complemento recebido: " + patio.getComplemento());
            patioRepository.save(patio);
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar cadastrar o pátio:");
            e.printStackTrace();
        }
        return patio;
    }

    public void removerPatio(Long id) throws IdNaoEncontradoException {

        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));
            patioRepository.deleteById(id);
            System.out.println("Patio: " + patio.getLogradouro() + ", " + patio.getCep() + " deletado com sucesso!");

    }

    @Transactional
    public void atualizarDadosPatio(Long id, Patio patio) throws IdNaoEncontradoException {
        Patio patioAchada = patioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Patio não encontrado"));
        patioAchada.setLogradouro(patio.getLogradouro());
        patioAchada.setNumero(patio.getNumero());
        patioAchada.setCep(patio.getCep());
        patioAchada.setComplemento(patio.getComplemento());
        patioAchada.setCidade(patio.getCidade());
        patioAchada.setUf(patio.getUf());
        patioAchada.setPais(patio.getPais());

        System.out.println("Patio: " + patioAchada.getIdPatio() + ", "
                + " atualizada com sucesso para: "
                + patio.getLogradouro() + " " + patio.getNumero() + ", "
                + patio.getComplemento() + ", " + patio.getCep() + ", " + patio.getCidade() +
                ", " + patio.getUf() + ", " + patio.getPais());

    }



    public Optional<Patio> visualizarDadosPatioEspecifico(Long id) {
        return patioRepository.findById(id);

    }
    public List<Patio> buscarTodosComAncoras() {
        return patioRepository.findAll();
    }

}
