/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;
import br.senac.tads.catdoggerenciador.entidades.Fornecedor;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.services.FornecedorService;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FornecedorAlterarControllerServlet", urlPatterns = { "/alterar-fornecedor" })
public class FornecedorAlterarControllerServlet extends HttpServlet {

    private final FornecedorService service;

    public FornecedorAlterarControllerServlet(){
        this.service = new FornecedorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("fornecedor", this.service.obterPorId(id));
        request.getRequestDispatcher("/WEB-INF/views/fornecedor/alterar-fornecedor.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("fornecedor");
        String razaoSocial = request.getParameter("razaoSocial");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));

        Fornecedor fornecedor = new Fornecedor(id, nome, razaoSocial, cnpj, cep, logradouro, numero, complemento, bairro, cidade, estado,
                 ativo);

        try {
            List<Notificacao> notificacoes = service.incluirOuAlterar(fornecedor);
            if (notificacoes.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/listar-fornecedor");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/fornecedor/incluir-fornecedor.jsp").forward(request,
                        response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.service.limparNotificacoes();
        }
    }
}
