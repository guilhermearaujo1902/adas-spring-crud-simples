package com.adas.contatos.controller;

import com.adas.contatos.model.Contato;
import com.adas.contatos.service.ContatosService;
import org.springframework.web.bind.annotation.*;

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

    /*
    *  TIPOS DE ENDPOINT
    *
    *  GET - Obter informação, exemplo: Buscar a lista de todos os contatos
    *  POST - Gerar dado novo no banco, exemplo: Cadastrar um novo usuário
    *  PUT - Atualizar dados no banco, exemplo: Alterar dados de um produto
    *  DELETE - Excluir dados, exemplo: Remover um registro do banco
    *
    * */

    @GetMapping
    public List<Contato> buscarTodos() {
        List<Contato> listaContatos = this.contatosService.buscarTodos();
        return listaContatos;
    }

    @GetMapping("/{codigo}")
    public Contato buscarPorCodigo(@PathVariable int codigo) {
        return this.contatosService.buscarPorCodigo(codigo);
    }

    @PostMapping("/novo")
    public Contato inserir(@RequestParam String nome, @RequestParam String telefone) {
        return this.contatosService.inserir(nome, telefone);
    }

    // Criar um endpoint para EXCLUIR um contato pelo código
    // Exemplo na Service: lista.remove(objetoParaExcluir)


    // Criar um endpoint para Habilitar ou desabilitar um contato da lista
    // Ajuste no objeto 'Contato' para adicionar a propriedade 'status'

}
