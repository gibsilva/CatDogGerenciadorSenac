/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Fornecedor;
import br.senac.tads.catdoggerenciador.services.FornecedorService;

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
@WebServlet(name = "FornecedorListarControllerServlet", urlPatterns = { "/listar-fornecedor" })
public class FornecedorListarControllerServlet extends HttpServlet {

    private final FornecedorService service;

    public FornecedorListarControllerServlet(){
        this.service = new FornecedorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Fornecedor> fornecedores = this.service.obterTodos();
        request.setAttribute("fornecedores", fornecedores);
        request.getRequestDispatcher("/WEB-INF/views/fornecedor/listar-fornecedor.jsp").forward(request, response);
    }

}
