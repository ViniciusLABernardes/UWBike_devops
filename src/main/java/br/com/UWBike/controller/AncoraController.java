package br.com.UWBike.controller;

import br.com.UWBike.dto.AncoraRequestDto;
import br.com.UWBike.exceptions.IdNaoEncontradoException;
import br.com.UWBike.model.Ancora;
import br.com.UWBike.model.Patio;
import br.com.UWBike.service.AncoraService;
import br.com.UWBike.service.PatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ancora")
public class AncoraController {

    @Autowired
    private AncoraService ancoraService;
    @Autowired
    private PatioService patioService;

    @GetMapping("/listar")
    public String listarAncoras(Model model) {
        List<Patio> patios = patioService.buscarTodosComAncoras();
        model.addAttribute("patios", patios);
        return "ancoras";
    }


    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model) {
        AncoraRequestDto dto = new AncoraRequestDto();
        model.addAttribute("ancora", dto);
        model.addAttribute("acao", "cadastrar");
        return "formulario-ancora";
    }


    @PostMapping("/salvar")
    public String salvarAncora(@ModelAttribute AncoraRequestDto ancoraDto) throws IdNaoEncontradoException {
        Long idPatio = ancoraDto.getIdPatio();
        if (idPatio == null || idPatio == 0L) {
            throw new IllegalArgumentException("Id do pátio obrigatório");
        }
        Patio patio = patioService.visualizarDadosPatioEspecifico(idPatio)
                .orElseThrow(() -> new IdNaoEncontradoException("Pátio não encontrado"));

        ancoraService.salvarAncoraComPatio(ancoraDto);
        return "redirect:/ancora/listar";
    }


    @GetMapping("/{id}/editar")
    public String exibirFormEdicao(@PathVariable Long id, Model model) {
        Ancora ancora = ancoraService.visualizarDadosAncoraEspecifica(id)
                .orElseThrow(() -> new RuntimeException("Ancora não encontrada"));
        model.addAttribute("ancora", ancora);
        model.addAttribute("acao", "editar");
        return "formulario-ancora";
    }


    @PostMapping("/{id}/atualizar")
    public String atualizarAncora(@PathVariable Long id, @ModelAttribute Ancora ancora) {
        try {
            ancoraService.atualizarDadosAncora(id, ancora);
        } catch (IdNaoEncontradoException e) {
            e.printStackTrace();
        }
        return "redirect:/ancora/listar";
    }


    @GetMapping("/{id}/remover")
    public String removerAncora(@PathVariable Long id) {
        try {
            ancoraService.removerAncora(id);
        } catch (IdNaoEncontradoException e) {
            e.printStackTrace();
        }
        return "redirect:/ancora/listar";
    }
}
