package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.services.ImagemService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.catdoggerenciador.services.ProdutoService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

@WebServlet(name = "ProdutoImagensServlet", urlPatterns = {"/alterar-imagens"})
public class ProdutoImagensServlet extends HttpServlet {

    private final ProdutoService produtoService;
    private final ImagemService imagemService;
    private FileOutputStream os;
    private final String DIRETORIO = "c:/uploads/";

    public ProdutoImagensServlet() {
        this.produtoService = new ProdutoService();
        this.imagemService = new ImagemService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
//        request.setAttribute("imagens", imagemService.obterPorIdDoProduto(idProduto));
//        request.getRequestDispatcher("/WEB-INF/views/produto/alterar-imagens.jsp").forward(request, response);
        String arquivo = request.getParameter("arquivo");
        File file = new File(arquivo);
        InputStream targetStream = new FileInputStream(file);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ajaxUpdateResult = "";
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

            for (Iterator it = items.iterator(); it.hasNext();) {
                FileItem item = (FileItem) it.next();
                if (item.isFormField()) {
                    ajaxUpdateResult += "Field " + item.getFieldName()
                            + " with value: " + item.getString() + " is successfully read\n\r";
                } else {
                    String fileName = item.getName();
                    InputStream content = item.getInputStream();
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    System.out.println(Streams.asString(content));
                    ajaxUpdateResult += "File " + fileName + " is successfully uploaded\n\r";
                }
            }
        } catch (FileUploadException e) {
            throw new ServletException("Parsing file upload failed.", e);
        }
        response.getWriter().print(ajaxUpdateResult);

    }
}
