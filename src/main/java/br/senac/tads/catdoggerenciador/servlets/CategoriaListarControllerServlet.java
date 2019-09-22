/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Categoria;
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
@WebServlet(name = "CategoriaListarControllerServlet", urlPatterns = {"/listar-categoria"})
public class CategoriaListarControllerServlet extends HttpServlet {

    private final CategoriaService categoriaService;

    public CategoriaListarControllerServlet() {
        this.categoriaService = new CategoriaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> categorias = categoriaService.obterTodas();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/WEB-INF/views/categoria/listar-categoria.jsp").forward(request, response);
    }

}
