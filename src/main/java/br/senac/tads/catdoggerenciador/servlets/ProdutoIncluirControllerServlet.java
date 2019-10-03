package br.senac.tads.catdoggerenciador.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.senac.tads.catdoggerenciador.entidades.Imagem;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import br.senac.tads.catdoggerenciador.entidades.enums.EPorteAnimal;
import br.senac.tads.catdoggerenciador.entidades.enums.ETipoAnimal;
import br.senac.tads.catdoggerenciador.helpers.Utils;
import br.senac.tads.catdoggerenciador.services.CategoriaService;
import br.senac.tads.catdoggerenciador.services.FornecedorService;
import br.senac.tads.catdoggerenciador.services.ProdutoService;
import java.io.File;
import java.io.FileOutputStream;

@WebServlet(name = "ProdutoIncluirServlet", urlPatterns = {"/incluir-produto"})
@MultipartConfig
public class ProdutoIncluirControllerServlet extends HttpServlet {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;
    private final FornecedorService fornecedorService;
    private FileOutputStream os;
    private final String DIRETORIO = "c:/uploads/";

    public ProdutoIncluirControllerServlet() {
        this.produtoService = new ProdutoService();
        this.categoriaService = new CategoriaService();
        this.fornecedorService = new FornecedorService();
        verificaDiretorio();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("categorias", categoriaService.obterTodas());
        request.setAttribute("fornecedores", fornecedorService.obterTodos());
        request.setAttribute("tipoAnimal", ETipoAnimal.values());
        request.setAttribute("porteAnimal", EPorteAnimal.values());
        request.getRequestDispatcher("/WEB-INF/views/produto/incluir-produto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utils utils = new Utils();

        String nome = request.getParameter("nomeProduto");
        String descricao = request.getParameter("descricao");
        String especificacao = request.getParameter("especificacao");
        double precoCompra = Double.parseDouble(utils.formatarValor(request.getParameter("precoCompra")));
        double precoVenda = Double.parseDouble(utils.formatarValor(request.getParameter("precoVenda")));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        int idFornecedor = Integer.parseInt(request.getParameter("fornecedor"));
        int porteAnimal = Integer.parseInt(request.getParameter("porteAnimal"));
        int tipoAnimal = Integer.parseInt(request.getParameter("tipoAnimal"));

        List<Imagem> imagens = new ArrayList<Imagem>();

        List<Part> arquivos = new ArrayList<>();
        for (Part part : request.getParts()) {
            if (part.getName().equals("imagem")) {
                arquivos.add(part);
            }
        }

        for (Part part : arquivos) {
            String fileName;
            String caminho;
            try (InputStream is = request.getPart(part.getName()).getInputStream()) {
                int i = is.available();
                byte[] b = new byte[i];
                is.read(b);
                fileName = getFileName(part);
                caminho = DIRETORIO + fileName; 
                //caminho = getCaminho(getServletContext().getRealPath("/imagens"), fileName);
                os = new FileOutputStream(caminho);
                os.write(b);
            }

            Imagem img = new Imagem(0, fileName, caminho, fileName.substring(fileName.length() - 4, fileName.length()), 0);
            imagens.add(img);
        }

        Produto produto = new Produto(
                0,
                nome,
                descricao,
                especificacao,
                precoCompra,
                precoVenda,
                quantidade,
                ativo,
                idCategoria,
                idFornecedor,
                EPorteAnimal.fromInt(porteAnimal),
                ETipoAnimal.fromInt(tipoAnimal)
        );

        produto.setImagens(imagens);

        try {
            List<Notificacao> notificacoes = produtoService.incluirOuAlterarProduto(produto);
            if (notificacoes.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/listar-produto");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/produto/incluir-produto.jsp").forward(request, response);
            }
        } catch (Exception e) {
            os.close();
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.produtoService.limparNotificacoes();
            os.close();
        }
    }

    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private String getCaminho(String caminho, String arquivo) {
        caminho = caminho.substring(0, caminho.indexOf("target"));
        return caminho + "\\imagens\\" + arquivo;
    }
    
    private void verificaDiretorio(){
        File diretorio = new File("c:/uploads");
        if(!diretorio.exists())
            diretorio.mkdir();
    }
}
