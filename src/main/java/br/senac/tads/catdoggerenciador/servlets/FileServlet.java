/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Imagem;
import br.senac.tads.catdoggerenciador.services.ImagemService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
@WebServlet(name = "FileServlet", urlPatterns = {"/imagem"})
public class FileServlet extends HttpServlet {

    private final ImagemService service;

    public FileServlet() {
        this.service = new ImagemService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idImagem"));
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        BufferedOutputStream output = null;
        try {
            Imagem imagem = service.obterPorId(id);
            fis = new FileInputStream(new File(imagem.getCaminho()));
            bis = new BufferedInputStream(fis);
            response.setContentType("image/jpeg");
            output = new BufferedOutputStream(response.getOutputStream());
            for (int data; (data = bis.read()) > -1;) {
                output.write(data);
            }
        } catch (IOException e) {

        } finally {
            fis.close();
            bis.close();
            output.close();
        }
    }
}
