package br.com.template.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import br.com.template.jwt.TokenUtil;

public class VerifyTokenFilter extends GenericFilterBean{

    private TokenUtil tokenUtil;
    private boolean urlAuthenticationNeeded;

    public VerifyTokenFilter(TokenUtil tUtil, boolean urlAuthenticationNeeded){
        this.tokenUtil = tUtil;
        this.urlAuthenticationNeeded = urlAuthenticationNeeded;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //HttpServletResponse response = (HttpServletResponse) res;

        try{
            Authentication auth = this.tokenUtil.verifyToken(request, urlAuthenticationNeeded);
            if(auth != null){
                SecurityContextHolder.getContext().setAuthentication(auth);
            }else{
                SecurityContextHolder.getContext().setAuthentication(null);
            }
            chain.doFilter(req, res);
        }catch(Exception ex){
            //response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //throw new RuntimeException(ex.getMessage(),ex);
            //chain.doFilter(req, res);
        	if(urlAuthenticationNeeded){
        		throw new RuntimeException(ex.getMessage());
        	}else{
        		chain.doFilter(req, res);
        	}
        }
    }
}
