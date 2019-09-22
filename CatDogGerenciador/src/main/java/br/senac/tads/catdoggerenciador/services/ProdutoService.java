/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.ProdutoDao;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import java.util.List;

/**
 *
 * @author Gi
 */
public class ProdutoService {

    private final ProdutoDao produtoDao;
    private final Notificacao notificacao;

    public ProdutoService() {
        this.notificacao = new Notificacao();
        this.produtoDao = new ProdutoDao();
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            this.notificacao.adicionaNotificacao("Não é possível inserir produto com quantidade negativa");
        }
    }

    private void validarValores(double valorCompra, double valorVenda) {
        if (valorCompra < 0 || valorVenda < 0) {
            this.notificacao.adicionaNotificacao("Valor de compra ou venda inválido");
        }
    }

    private boolean validarProduto(Produto produto) {
        validarQuantidade(produto.getQuantidade());
        validarValores(produto.getPrecoCompra(), produto.getPrecoVenda());

        return this.notificacao.temNotificacoes();
    }

    public Produto obterPorId(int id) {
        return this.produtoDao.obterPorId(id);
    }

    public List<Produto> obterTodos() {
        return this.produtoDao.obterTodos();
    }

    public void limparNotificacoes() {
        this.notificacao.limparNotificacoes();
    }

    public List<Notificacao> incluirOuAlterarProduto(Produto produto) throws Exception {
        try {
            if (validarProduto(produto)) {
                if (produto.getId() == 0) {
                    produtoDao.salvar(produto);
                } else {
                    produtoDao.alterar(produto);
                }
            }
            return this.notificacao.getNotificacaoes();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
