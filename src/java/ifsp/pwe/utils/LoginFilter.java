package ifsp.pwe.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
            TODO - Descomentar quando a bean usuario estiver pronta.
        
        Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario_logado");


        if(usuario == null){
            ((HttpServletResponse) response).sendRedirect("index.xhtml");
        }
        */

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }   
}