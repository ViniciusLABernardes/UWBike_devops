package br.com.UWBike.controller;

import br.com.UWBike.exceptions.IdNaoEncontradoException;
import br.com.UWBike.model.Patio;
import br.com.UWBike.service.PatioService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patio")
public class PatioController {



        @Autowired
        private PatioService patioService;


        @GetMapping("/listar")
        public String listarPatios(Model model) {
            List<Patio> patios = patioService.buscarTodosComAncoras();
            model.addAttribute("patios", patios);
            return "patios";
        }


        @GetMapping("/cadastrar")
        public String exibirFormCadastro(Model model) {
            model.addAttribute("patio", new Patio());
            model.addAttribute("acao", "cadastrar");
            return "formulario-patio";
        }


        @PostMapping("/salvar")
        public String salvarPatio(@ModelAttribute Patio patio) {
            patioService.salvarPatio(patio);
            return "redirect:/patio/listar";
        }


        @GetMapping("/{id}/editar")
        public String exibirFormEdicao(@PathVariable Long id, Model model) throws IdNaoEncontradoException {
            Patio patio = patioService.visualizarDadosPatioEspecifico(id)
                    .orElseThrow(() -> new IdNaoEncontradoException("Pátio não encontrado"));
            model.addAttribute("patio", patio);
            model.addAttribute("acao", "editar");
            return "formulario-patio";
        }


        @PostMapping("/{id}/atualizar")
        public String atualizarPatio(@PathVariable Long id, @ModelAttribute Patio patio) throws IdNaoEncontradoException {
            patioService.atualizarDadosPatio(id, patio);
            return "redirect:/patio/listar";
        }


        @GetMapping("/{id}/remover")
        public String removerPatio(@PathVariable Long id) throws IdNaoEncontradoException {
            patioService.removerPatio(id);
            return "redirect:/patio/listar";
        }
    }

