package br.com.UWBike.controller;


import br.com.UWBike.exceptions.IdNaoEncontradoException;
import br.com.UWBike.model.Funcionario;
import br.com.UWBike.model.Moto;
import br.com.UWBike.model.MotoPatio;
import br.com.UWBike.model.Patio;
import br.com.UWBike.service.FuncionarioService;
import br.com.UWBike.service.MotoPatioService;
import br.com.UWBike.service.MotoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/moto")
public class MotoController{
        @Autowired
        private MotoService motoService;

        @Autowired
        private FuncionarioService funcionarioService;

        @Autowired
        private MotoPatioService motoPatioService;

        @GetMapping("/novo")
        public String novaMotoForm(Model model) {
            model.addAttribute("moto", new Moto());
            return "formulario-moto";
        }


        @PostMapping("/salvar")
        public String salvarMoto(@ModelAttribute Moto moto, Principal principal) throws IdNaoEncontradoException {
            try {

                String loginUsuario = principal.getName();

                Funcionario funcionario = funcionarioService.buscarPorLogin(loginUsuario)
                        .orElseThrow(() -> new IdNaoEncontradoException("Funcionário não encontrado"));


                motoService.salvarMoto(moto, funcionario.getIdFuncionario());

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
            }
            return "redirect:/index";
        }


        @GetMapping("/{id}/editar")
        public String editarMotoForm(@PathVariable Long id, Model model) throws IdNaoEncontradoException {
            Moto moto = motoService.visualizarDadosMotoEspecifica(id)
                    .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));
            model.addAttribute("moto", moto);
            return "formulario-moto";
        }


        @PostMapping("/{id}/atualizar")
        public String atualizarMoto(@PathVariable Long id, @ModelAttribute Moto moto) throws IdNaoEncontradoException {
            motoService.atualizarDadosMoto(id, moto);
            return "redirect:/index";
        }


        @PostMapping("/{id}/excluir")
        public String excluirMoto(@PathVariable Long id) throws IdNaoEncontradoException {
            motoService.removerMoto(id);
            return "redirect:/index";
        }

    @PostMapping("/{id}/saida")
    public String registrarSaidaMoto(@PathVariable Long id, Model model) {
        try {
            MotoPatio motoPatio = motoPatioService.adicionarSaidaMoto(id);
            model.addAttribute("sucesso", "Saída registrada com sucesso para a moto ID " + id);
        } catch (IdNaoEncontradoException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/index";
    }

}
