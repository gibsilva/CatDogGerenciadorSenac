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
@WebServlet(name = "FornecedorIncluirControllerServlet", urlPatterns = {"/incluir-fornecedor"})
public class FornecedorIncluirControllerServlet extends HttpServlet {
    
    private final FornecedorService service;
    
    public FornecedorIncluirControllerServlet(){
        this.service = new FornecedorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/fornecedor/incluir-fornecedor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        Fornecedor fornecedor = new Fornecedor(0, nome, razaoSocial, cnpj, cep, logradouro, numero, complemento, bairro, cidade, estado, ativo);
             
        try{
            List<Notificacao> notificacoes = service.incluirOuAlterar(fornecedor);
            if(notificacoes.isEmpty()){
                response.sendRedirect(request.getContextPath() + "/listar-fornecedor");
            } else{
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/fornecedor/incluir-fornecedor.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.service.limparNotificacoes();
        }
        
    }
}
