package br.senac.tads.catdoggerenciador.dao.interfaces;

import java.util.List;

import br.senac.tads.catdoggerenciador.entidades.Produto;

public interface IProdutoDao {

    Produto obterPorId(int id);

    List<Produto> obterTodos();

    void salvar(Produto produto);

    void alterar(Produto produto);
    
    int ultimoIdSalvo();
}
