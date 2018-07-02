package ifsp.pwe.utils;

import ifsp.pwe.beans.Proprietario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginProprietarioFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {     
        Object pessoa = ((HttpServletRequest) request).getSession().getAttribute("usuario_logado");

        if(pessoa == null){
            ((HttpServletResponse) response).sendRedirect("../index.xhtml");
        }else if(!(pessoa instanceof Proprietario)){
            ((HttpServletResponse) response).sendRedirect("recepcionista.xhtml");
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }   
}