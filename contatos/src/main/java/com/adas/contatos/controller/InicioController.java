package com.adas.contatos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class InicioController {

    @GetMapping
    public String iniciar() {
        return "Chegou ao endpoint .../inicio";
    }

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Bem vindos ao sistema de Contatos Adas";
    }

    @GetMapping("/sistema")
    public String getNomeSistema() {
        return "Adas Contatos System .....";
    }

}
