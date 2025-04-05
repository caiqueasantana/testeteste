package com.exemplo.sequencia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SequenciaController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/resultado")
    public String resultado(@RequestParam("numero") int numero, Model model) {
        List<Integer> sequencia = new ArrayList<>();
        String tipo = "";

        if (numero <= 0) {
            tipo = "Número inválido. Por favor, insira um número positivo.";
        } else if (numero % 2 == 0) {
            tipo = "Números pares de 0 até " + numero;
            for (int i = 0; i <= numero; i += 2) {
                sequencia.add(i);
            }
        } else {
            tipo = "Números ímpares de 1 até " + numero;
            for (int i = 1; i <= numero; i += 2) {
                sequencia.add(i);
            }
        }

        model.addAttribute("tipo", tipo);
        model.addAttribute("sequencia", sequencia);
        return "index";
    }
}
