package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Imagem;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import br.senac.tads.catdoggerenciador.entidades.enums.EPorteAnimal;
import br.senac.tads.catdoggerenciador.entidades.enums.ETipoAnimal;
import br.senac.tads.catdoggerenciador.helpers.Utils;
import br.senac.tads.catdoggerenciador.services.CategoriaService;
import br.senac.tads.catdoggerenciador.services.FornecedorService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.catdoggerenciador.services.ProdutoService;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.Part;

@WebServlet(name = "ProdutoAlterarControllerServlet", urlPatterns = {"/alterar-produto"})
public class ProdutoAlterarControllerServlet extends HttpServlet {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;
    private final FornecedorService fornecedorService;
    private final String UPLOAD_DIRECTORY;

    public ProdutoAlterarControllerServlet() {
        this.produtoService = new ProdutoService();
        this.categoriaService = new CategoriaService();
        this.fornecedorService = new FornecedorService();
        this.UPLOAD_DIRECTORY = "C:/uploads";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produto p = produtoService.obterPorId(id);
        request.setAttribute("produto", p);
        request.setAttribute("categorias", categoriaService.obterTodas());
        request.setAttribute("fornecedores", fornecedorService.obterTodos());
        request.setAttribute("tipoAnimal", ETipoAnimal.values());
        request.setAttribute("porteAnimal", EPorteAnimal.values());
        request.getRequestDispatcher("/WEB-INF/views/produto/alterar-produto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utils utils = new Utils();

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nomeProduto");
        String descricao = request.getParameter("descricao");
        String especificacao = request.getParameter("especificacao");
        double precoCompra = Double.parseDouble(utils.formatarValor(request.getParameter("precoCompra")));
        double precoVenda = Double.parseDouble(utils.formatarValor(request.getParameter("precoVenda")));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
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
                caminho = UPLOAD_DIRECTORY + fileName;
                FileOutputStream os = new FileOutputStream(caminho);
                os.write(b);
            }

            Imagem img = new Imagem(0, fileName, caminho, fileName.substring(fileName.length() - 4, fileName.length()), 0);
            imagens.add(img);
        }

        Produto produto = new Produto(
                id,
                nome,
                descricao,
                especificacao,
                precoCompra,
                precoVenda,
                quantidade,
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
                request.getRequestDispatcher("/WEB-INF/views/produto/alterar-produto.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.produtoService.limparNotificacoes();
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
}
