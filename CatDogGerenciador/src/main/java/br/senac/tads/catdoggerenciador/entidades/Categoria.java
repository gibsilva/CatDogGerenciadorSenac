package br.senac.tads.catdoggerenciador.entidades;

import java.util.ArrayList;
import java.util.List;

public class Categoria extends Entidade {

    private String nome;
    private List<Produto> produtos;

    public Categoria(int id, String nome) {
        super(id);
        this.nome = nome;
        this.produtos = new ArrayList<Produto>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
