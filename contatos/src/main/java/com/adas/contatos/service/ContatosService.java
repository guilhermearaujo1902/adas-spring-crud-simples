package com.adas.contatos.service;

import com.adas.contatos.model.Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatosService {

    // Declarando uma lista de contatos para simular um banco de dados
    List<Contato> listaContatos = new ArrayList<>();

    Integer proximoCodigo = 1;

    // Função responável por retornar a lista atualizada de contatos
    public List<Contato> buscarTodos() {
        return this.listaContatos;
    }

    // Função responsável por encontrar um contato com o código igual ao enviado por parametro
    public Contato buscarPorCodigo(int codigo) {
        Contato contatoEncontrado = null;

        // Percorrer a lista para verificar se algum contato tem o código buscado
        for (Contato contatoAtual : this.listaContatos) {
            if (contatoAtual.getCodigo() == codigo) {
                contatoEncontrado = contatoAtual;
            }
        }

        return contatoEncontrado;
    }

    // Função responsável por receber um os dados do novo contato e salvar dentro da lista
    public Contato inserir(String nome, String telefone) {
        Contato novoContato = new Contato();

        novoContato.setCodigo(this.proximoCodigo);
        novoContato.setNome(nome);
        novoContato.setTelefone(telefone);

        this.listaContatos.add(novoContato);

        this.proximoCodigo++;

        return novoContato;
    }

    public Contato excluir(int codigo) {
        Contato contatoParaExcluir = this.buscarPorCodigo(codigo);

        if (contatoParaExcluir != null) {
            this.listaContatos.remove(contatoParaExcluir);
        }

        return contatoParaExcluir;
    }

    public Contato editar(int codigo, String novoNome, String novoTelefone) {
        Contato contatoParaEditar = this.buscarPorCodigo(codigo);

        if (contatoParaEditar != null) {
            contatoParaEditar.setNome(novoNome);
            contatoParaEditar.setTelefone(novoTelefone);
        }

        return contatoParaEditar;
    }

}
