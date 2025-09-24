package br.com.UWBike.controller;

import br.com.UWBike.model.Funcionario;
import br.com.UWBike.model.Moto;
import br.com.UWBike.model.MotoPatio;
import br.com.UWBike.model.Patio;
import br.com.UWBike.service.FuncionarioService;
import br.com.UWBike.service.MotoPatioService;
import br.com.UWBike.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("")
public class MotoPatioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private MotoPatioService motoPatioService;


    @GetMapping("/index")
    public String listarMotosFuncionarioLogado(Model model, Authentication authentication) {


        String login = authentication.getName();


        Optional<Funcionario> funcionarioOpt = funcionarioService.buscarPorLogin(login);

        List<MotoPatio> motos = new ArrayList<>();

        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();

            for (Patio patio : funcionario.getPatios()) {
                motos.addAll(motoPatioService.listarMotosPorPatio(patio));
            }
        }

        model.addAttribute("motosPatio", motos);
        return "index";
    }

    @GetMapping("/calcular")
    public String exibirForm(Model model) {
        model.addAttribute("motoId", null);
        model.addAttribute("patioId", null);
        model.addAttribute("d1", null);
        model.addAttribute("d2", null);
        model.addAttribute("d3", null);
        model.addAttribute("resultado", null);
        return "achar-moto";
    }


    @PostMapping("/calcular")
    public String calcularPosicao(
            @RequestParam("motoId") long motoId,
            @RequestParam("patioId") long patioId,
            @RequestParam("d1") double d1,
            @RequestParam("d2") double d2,
            @RequestParam("d3") double d3,
            Model model) {

        try {
            Moto moto = motoPatioService.calcularPosicaoMoto(motoId, patioId, d1, d2, d3);
            model.addAttribute("resultado", moto);
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
        }

        model.addAttribute("motoId", motoId);
        model.addAttribute("patioId", patioId);
        model.addAttribute("d1", d1);
        model.addAttribute("d2", d2);
        model.addAttribute("d3", d3);

        return "achar-moto";
    }
}
