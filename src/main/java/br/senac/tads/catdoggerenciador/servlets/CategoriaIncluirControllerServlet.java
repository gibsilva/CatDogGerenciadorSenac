package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Categoria;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.catdoggerenciador.services.CategoriaService;

@WebServlet(name = "/CategoriaIncluirControllerServlet", urlPatterns = "/incluir-categoria")
public class CategoriaIncluirControllerServlet extends HttpServlet {

    private final CategoriaService service = new CategoriaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/categoria/incluir-categoria.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeCategoria = request.getParameter("categoria");

        Categoria categoria = new Categoria(0, nomeCategoria);

        List<Notificacao> notificacoes = service.salvar(categoria);

        try {
            if (notificacoes.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/WEB-INF/views/categoria/listar-categoria.jsp");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/categoria/incluir-categoria.jsp").forward(request, response);
            }
        } catch(IOException | ServletException e)  {
            request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
        } finally {
            service.limparNotificacoes();
        }

    }

}
