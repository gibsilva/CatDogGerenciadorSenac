/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Usuario;
import br.senac.tads.catdoggerenciador.helpers.Utils;
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
@WebServlet(name = "UsuarioIncluirControllerServlet", urlPatterns = {"/incluir-usuario"})
public class UsuarioIncluirControllerServlet extends HttpServlet {

    private final UsuarioService service;

    public UsuarioIncluirControllerServlet() {
        this.service = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/usuario/incluir-usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utils utils = new Utils();
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String permissao = request.getParameter("permissao");
        

        Usuario usuario = new Usuario(0, nome, cpf, email, senha, permissao, true);

        try {
            List<Notificacao> notificacoes = service.incluirOuAlterar(usuario);
            if (notificacoes.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/listar-usuario");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/usuario/incluir-usuario.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.service.limparNotificacoes();
        }

    }

}
