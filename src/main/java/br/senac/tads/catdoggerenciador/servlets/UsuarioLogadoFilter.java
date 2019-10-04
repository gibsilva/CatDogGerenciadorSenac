package br.senac.tads.catdoggerenciador.servlets;

import br.senac.tads.catdoggerenciador.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gi
 */
@WebFilter(filterName = "UsuarioLogadoFilter", urlPatterns = {"/incluir-produto","/incluir-categoria","/incluir-usuario", 
    "/incluir-fornecedor","/alterar-usuario","/alterar-categoria", "/alterar-fornecedor"})
public class UsuarioLogadoFilter implements Filter {

    private String contextPath;

    private final FilterConfig filterConfig = null;

    public UsuarioLogadoFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("usuarioLogado") == null) {
            session.invalidate();
            res.sendRedirect(contextPath + "/login");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (verificarAcesso(usuario, req, res)) {
            res.setHeader("Cache-Control", "no-cache, no-store");
            res.setHeader("Pragma", "no-cache");
            res.setHeader("Expires", "-1");
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/nao-autorizado.jsp");
        }
    }

    private boolean verificarAcesso(Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String url = getFullURL(request);
        
        return !(usuario.getPermissao().getOpcao() == 2 && !url.contains("alterar-produto"));
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.contextPath = filterConfig.getServletContext().getContextPath();
    }

    public static String getFullURL(HttpServletRequest request) {
        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
}
