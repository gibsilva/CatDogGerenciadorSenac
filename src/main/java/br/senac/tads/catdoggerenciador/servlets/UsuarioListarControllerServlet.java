/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.services.UsuarioService;
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
@WebServlet(name = "UsuarioListarControllerServlet", urlPatterns = {"/listar-usuario"})
public class UsuarioListarControllerServlet extends HttpServlet {
     private final UsuarioService service;

    public UsuarioListarControllerServlet(){
        this.service = new UsuarioService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("usuarios", service.obterTodos());
        request.getRequestDispatcher("/WEB-INF/views/usuario/listar-usuario.jsp").forward(request, response);
    }
}
