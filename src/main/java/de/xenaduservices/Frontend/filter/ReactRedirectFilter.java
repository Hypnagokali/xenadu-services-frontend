package de.xenaduservices.Frontend.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class ReactRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String requestURI = servletRequest.getRequestURI();

        if (requestURI.startsWith("/react")
                || requestURI.startsWith("/assets")
                || requestURI.startsWith("/login")
                || requestURI.startsWith("/logout")) {
            chain.doFilter(request, response);
            return;
        }

        servletRequest.getRequestDispatcher("/").forward(request, response);

    }
}
