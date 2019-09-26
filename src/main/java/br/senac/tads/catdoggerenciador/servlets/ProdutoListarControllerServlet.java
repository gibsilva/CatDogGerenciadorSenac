package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.catdoggerenciador.services.ProdutoService;

@WebServlet(name = "ProdutoListarControllerServlet", urlPatterns = {"/listar-produto"})
public class ProdutoListarControllerServlet extends HttpServlet {

    private final ProdutoService produtoService;

    public ProdutoListarControllerServlet() {
        this.produtoService = new ProdutoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produto> produtos = produtoService.obterTodosListar();
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("/WEB-INF/views/produto/listar-produto.jsp").forward(request, response);
    }

}
