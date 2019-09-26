package br.senac.tads.catdoggerenciador.dao.interfaces;

import java.util.List;

import br.senac.tads.catdoggerenciador.entidades.Fornecedor;;

public interface IFornecedorDao {
    Fornecedor obterPorId(int id);
    List<Fornecedor> obterTodos();
    void salvar(Fornecedor fornecedor);
    void alterar(Fornecedor fornecedor);
    void excluir(Fornecedor fornecedor);
    void alterarStatus(Fornecedor fornecedor);
}