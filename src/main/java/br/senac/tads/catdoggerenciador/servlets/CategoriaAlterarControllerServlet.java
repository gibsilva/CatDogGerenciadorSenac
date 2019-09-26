/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Categoria;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.services.CategoriaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gi
 */
@WebServlet(name = "/CategoriaAlterarControllerServlet", urlPatterns = "/alterar-categoria")
public class CategoriaAlterarControllerServlet extends HttpServlet {

    private final CategoriaService service = new CategoriaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("categoria", service.obterPorId(id));
        request.getRequestDispatcher("/WEB-INF/views/categoria/alterar-categoria.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nomeCategoria = request.getParameter("categoria");
        
        Categoria categoria = new Categoria(id, nomeCategoria);

        List<Notificacao> notificacoes = service.salvarOuAlterar(categoria);

        try {
            if (notificacoes.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/listar-categoria");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/categoria/incluir-categoria.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        } finally {
            service.limparNotificacoes();
        }
    }
}
