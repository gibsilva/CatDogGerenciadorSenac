package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import br.senac.tads.catdoggerenciador.helpers.Utils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.catdoggerenciador.services.CategoriaService;
import br.senac.tads.catdoggerenciador.services.FornecedorService;
import br.senac.tads.catdoggerenciador.services.ProdutoService;
import br.senac.tads.catdoggerenciador.services.RacaService;

@WebServlet(name = "ProdutoIncluirServlet", urlPatterns = {"/incluir-produto"})
public class ProdutoIncluirControllerServlet extends HttpServlet {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;
    private final FornecedorService fornecedorService;
    private final RacaService racaService;

    public ProdutoIncluirControllerServlet() {
        this.produtoService = new ProdutoService();
        this.categoriaService = new CategoriaService();
        this.fornecedorService = new FornecedorService();
        this.racaService = new RacaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("categorias", categoriaService.obterTodas());
        request.setAttribute("fornecedores", fornecedorService.obterTodos());
        request.setAttribute("racas", racaService.obterTodas());
        request.getRequestDispatcher("/WEB-INF/views/produto/incluir-produto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Utils utils = new Utils();

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String especificacao = request.getParameter("especificacao");
        double precoCompra = Double.parseDouble(utils.formatarValor(request.getParameter("precoCompra")));
        double precoVenda = Double.parseDouble(utils.formatarValor(request.getParameter("precoVenda")));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idRaca = Integer.parseInt(request.getParameter("raca"));
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        int idFornecedor = Integer.parseInt(request.getParameter("fornecedor"));

        Produto produto = new Produto(0, nome, descricao, especificacao, precoCompra, precoVenda, quantidade, idCategoria, idFornecedor, idRaca);

        try {
            List<Notificacao> notificacoes = produtoService.incluirOuAlterarProduto(produto);
            if (notificacoes.isEmpty()) {
                response.sendRedirect("/WEB-INF/views/produto/listar-produto.jsp");
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.getRequestDispatcher("/WEB-INF/views/produto/incluir-produto.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            this.produtoService.limparNotificacoes();
        }
    }

}
