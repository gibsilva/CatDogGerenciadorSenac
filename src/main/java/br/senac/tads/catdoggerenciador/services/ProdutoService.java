package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.CategoriaDao;
import br.senac.tads.catdoggerenciador.dao.FornecedorDao;
import br.senac.tads.catdoggerenciador.dao.ImagemDao;
import br.senac.tads.catdoggerenciador.dao.ProdutoDao;
import br.senac.tads.catdoggerenciador.entidades.Imagem;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import java.util.List;

/**
 *
 * @author Gi
 */
public class ProdutoService {

    private final ProdutoDao produtoDao;
    private final FornecedorDao fornecedorDao;
    private final ImagemDao imagemDao;
    private final CategoriaDao categoriaDao;
    private final Notificacao notificacao;

    public ProdutoService() {
        this.notificacao = new Notificacao();
        this.produtoDao = new ProdutoDao();
        this.fornecedorDao = new FornecedorDao();
        this.imagemDao = new ImagemDao();
        this.categoriaDao = new CategoriaDao();
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
        Produto produto = this.produtoDao.obterPorId(id);
        produto.setImagens(this.imagemDao.obterPorIdProduto(produto.getId()));
        produto.setFornecedor(this.fornecedorDao.obterPorId(produto.getIdFornecedor()));
        produto.setCategoria(this.categoriaDao.obterPorId(produto.getIdCategoria()));
        return produto;
    }

    public List<Produto> obterTodos() {
        List<Produto> produtos = this.produtoDao.obterTodos();
        for (Produto p : produtos) {
            p.setImagens(this.imagemDao.obterPorIdProduto(p.getId()));
            p.setFornecedor(this.fornecedorDao.obterPorId(p.getIdFornecedor()));
            p.setCategoria(this.categoriaDao.obterPorId(p.getIdCategoria()));
        }
        return produtos;
    }

    public List<Produto> obterTodosListar() {
        return this.produtoDao.obterTodos();
    }

    public void limparNotificacoes() {
        this.notificacao.limparNotificacoes();
    }

    public int obterUltimoIdSalvo() {
        return this.produtoDao.ultimoIdSalvo();
    }

    public List<Notificacao> incluirOuAlterarProduto(Produto produto) throws Exception {
        try {
            if (validarProduto(produto)) {
                if (produto.getId() == 0) {
                    produtoDao.salvar(produto);
                    setIdProdutoImagens(produto);
                } else {
                    produtoDao.alterar(produto);
                }
            }
            return this.notificacao.getNotificacaoes();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void setIdProdutoImagens(Produto p) {
        int idProduto = obterUltimoIdSalvo();
        for (Imagem img : p.getImagens()) {
            img.setIdProduto(idProduto);
            ImagemDao imagemDao = new ImagemDao();
            imagemDao.salvar(img);
        }
    }
}
