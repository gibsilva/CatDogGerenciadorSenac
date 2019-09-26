package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Produto;
import br.senac.tads.catdoggerenciador.services.ProdutoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gi
 */
@WebServlet(name = "ProdutoDetalhesControllerServlet", urlPatterns = {"/detalhes-produto"})
public class ProdutoDetalhesControllerServlet extends HttpServlet {
    private final ProdutoService service;

    public ProdutoDetalhesControllerServlet(){
        this.service = new ProdutoService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produto p = this.service.obterPorId(id);
        request.setAttribute("produto", p);
        request.getRequestDispatcher("/WEB-INF/views/produto/detalhes-produto.jsp").forward(request, response);
    }
}
