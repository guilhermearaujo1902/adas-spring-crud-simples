package com.adas.contatos.service;

import com.adas.contatos.model.Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatosService {

    // Declarando uma lista de contatos para simular um banco de dados
    List<Contato> listaContatos = new ArrayList<>();

    // Função responável por retornar a lista atualizada de contatos
    public List<Contato> findAll() {
        return this.listaContatos;
    }

    // Função responsável por receber um 'novo contato' e salvar dentro da lista
    public String insert(String nome) {
        Contato novoContato = new Contato();
        novoContato.setNome(nome);
        this.listaContatos.add(novoContato);
        return novoContato.getNome();
    }

}
