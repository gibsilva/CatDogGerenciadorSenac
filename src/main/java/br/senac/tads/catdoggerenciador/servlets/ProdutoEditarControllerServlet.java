package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import br.senac.tads.catdoggerenciador.helpers.Utils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.catdoggerenciador.services.ProdutoService;

@WebServlet(name = "ProdutoEditarControllerServlet", urlPatterns = {"/editar-produto"})
public class ProdutoEditarControllerServlet extends HttpServlet {

    private final ProdutoService produtoService;

    public ProdutoEditarControllerServlet() {
        this.produtoService = new ProdutoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/produto/editar-produto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        Utils utils = new Utils();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String especificacao = request.getParameter("especificacao");
        double precoCompra = Double.parseDouble(utils.formatarValor(request.getParameter("valorCompra")));
        double precoVenda = Double.parseDouble(utils.formatarValor(request.getParameter("valorVenda")));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idRaca = Integer.parseInt(request.getParameter("idRaca"));
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        int idFornecedor = Integer.parseInt(request.getParameter("fornecedor"));

        Produto produto = new Produto(id, nome, descricao, especificacao, precoCompra, precoVenda, quantidade, idCategoria, idFornecedor, idRaca);

        try {
            List<Notificacao> notificacoes = produtoService.incluirOuAlterarProduto(produto);
            if (notificacoes.isEmpty()) {
                response.sendRedirect("/WEB-INF/views/produto/listar-produto.jsp");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/produto/incluir-produto.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.produtoService.limparNotificacoes();
        }
    }

}
