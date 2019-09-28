/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Usuario;
import br.senac.tads.catdoggerenciador.services.UsuarioService;
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
@WebServlet(name = "UsuarioAlterarControllerServlet", urlPatterns = {"/alterar-usuario"})
public class UsuarioAlterarControllerServlet extends HttpServlet {

    private final UsuarioService service;

    public UsuarioAlterarControllerServlet() {
        this.service = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("usuario", this.service.obterPorId(id));
        request.getRequestDispatcher("/WEB-INF/views/usuario/alterar-usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));
        String permissao = request.getParameter("permissao");

        Usuario usuario = new Usuario(0, nome, cpf, email, login, senha, true, permissao);

        try {
            List<Notificacao> notificacoes = service.incluirOuAlterar(usuario);
            if (notificacoes.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/listar-usuario");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/usuario/alterar-usuario.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.service.limparNotificacoes();
        }
    }
}
