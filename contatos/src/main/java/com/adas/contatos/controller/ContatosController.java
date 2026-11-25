package com.adas.contatos.controller;

import com.adas.contatos.service.ContatosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

    /*
        Versão desatualizada de instanciar um serviço
        @Autowired
        private ContatosService contatosService;
    */

    // Forma atual de instanciar um serviço

    // Criando o objeto que vai receber a instancia da classe de serviço
    // através do construtor
    private final ContatosService contatosService;

    // Atribuindo ao objeto local uma instancia nova do serviço da classe 'ContatosService'
    public ContatosController(ContatosService contatosService) {
        this.contatosService = contatosService;
    }

    @GetMapping
    public List<String> findAll() {
        List<String> listaContatos = this.contatosService.findAll();
        return listaContatos;
    }

    @GetMapping("/novo")
    public String insert(@RequestParam String novoContato) {
        String contatoSalvo = this.contatosService.insert(novoContato);
        return "Novo contato salvo na lista: " + contatoSalvo;
    }

}
