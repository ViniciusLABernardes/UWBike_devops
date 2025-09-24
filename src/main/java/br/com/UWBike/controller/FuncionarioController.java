package br.com.UWBike.controller;

import br.com.UWBike.dto.FuncionarioRequestDto;
import br.com.UWBike.exceptions.IdNaoEncontradoException;
import br.com.UWBike.model.Funcionario;
import br.com.UWBike.model.Patio;
import br.com.UWBike.service.FuncionarioService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model) {
        model.addAttribute("funcionario", new FuncionarioRequestDto());
        return "formulario-funcionario";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute("funcionario") FuncionarioRequestDto dto) throws Exception {

        funcionarioService.salvarFuncionario(dto);
        return "redirect:/funcionario/funcionarios";
    }


    @PostMapping("/{id}/excluir")
    public String removerFuncionario(@PathVariable Long id, Model model) {
        try {
            funcionarioService.removerFuncionario(id);
        } catch (IdNaoEncontradoException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/funcionario/funcionarios";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Funcionario funcionario = funcionarioService.visualizarDadosFuncionarioEspecifico(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

            model.addAttribute("funcionario", funcionario);
            return "formulario-funcionario";


    }

    @PostMapping("/{id}/atualizar")
    public String atualizarFuncionario(@PathVariable Long id,
                                       @ModelAttribute Funcionario funcionario,
                                       Model model) {
        try {
            funcionarioService.atualizarDadosFuncionario(id, funcionario);
        } catch (IdNaoEncontradoException e) {
            model.addAttribute("erro", e.getMessage());
            return "funcionario/editar";
        }

        return "redirect:/funcionario/funcionarios";
    }


    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
        List<Patio> patios = funcionarioService.listarFuncionariosPorPatio();
        model.addAttribute("patios", patios);
        return "funcionarios";
    }



}
