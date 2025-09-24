package br.com.UWBike.service;


import br.com.UWBike.dto.AncoraRequestDto;
import br.com.UWBike.exceptions.IdNaoEncontradoException;
import br.com.UWBike.model.Ancora;
import br.com.UWBike.model.Patio;
import br.com.UWBike.repository.AncoraRepository;
import br.com.UWBike.repository.PatioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AncoraService {

    @Autowired
    private PatioRepository patioRepository;
    @Autowired
    private AncoraRepository ancoraRepository;

    public Ancora salvarAncoraComPatio(AncoraRequestDto ancoraDto) throws IdNaoEncontradoException {
        Ancora ancoraNova = new Ancora();
        try {
            ancoraNova.setX(ancoraDto.getX());
            ancoraNova.setY(ancoraDto.getY());

            Optional<Patio> patioOpt = patioRepository.findById(ancoraDto.getIdPatio());
            if (patioOpt.isEmpty()) {
                throw new IdNaoEncontradoException("Patio não encontrado com id: " + ancoraDto.getIdPatio());
            }

            ancoraNova.setPatio(patioOpt.get());


            ancoraRepository.save(ancoraNova);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ancoraNova;
    }

    public void removerAncora(Long id) throws IdNaoEncontradoException {
        Ancora ancoraAchada = ancoraRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Ancora não encontrada"));

        ancoraRepository.deleteById(id);

        System.out.println("Ancora: " + ancoraAchada.getId() + ", " + ancoraAchada.getX() + " " + ancoraAchada.getY() + " deletada com sucesso!");

    }

    @Transactional
    public void atualizarDadosAncora(Long id, Ancora ancora) throws IdNaoEncontradoException{
        Ancora ancoraAchada = ancoraRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Ancora não encontrada"));

        ancoraAchada.setX(ancora.getX());
        ancoraAchada.setY(ancora.getY());

        System.out.println("Ancora: " + ancoraAchada.getId() + ", "
                + " atualizada com sucesso para: " + ancora.getX() + " " + ancora.getY());

    }

    public Optional<Ancora> visualizarDadosAncoraEspecifica(Long id) {
        return ancoraRepository.findById(id);

    }
}
