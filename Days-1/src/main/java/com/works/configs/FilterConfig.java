package com.works.configs;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("SERVER UP");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        System.out.println(url);
        boolean statusLogin = true;
        if (url.contains("/customer") || url.contains("/errorLogin") || url.contains("/h2-console")) {
            statusLogin = false;
        }

        if (statusLogin) {
            boolean status = req.getSession().getAttribute("user") == null;
            if (status) {
                res.sendRedirect("/errorLogin");
            }else {
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }

    }

    @Override
    public void destroy() {
        System.out.println("SERVER DOWN");
    }

}
