package com.z4greed.config;

//import org.springframework.core.annotation.Order;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationToken;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(1) // Orden de ejecución del filtro
//public class JwtTokenPropagationFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder
//                .getContext()
//                .getAuthentication();
//
//        if (authentication != null && authentication.isAuthenticated()) {
//            String token = authentication.getPrincipal().getAttribute("access_token");
//            if (token != null) {
//                // Agrega el token JWT al encabezado de autorización de la solicitud
//                request.setAttribute("Authorization", "Bearer " + token);
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Método de inicialización, si es necesario
//    }
//
//    @Override
//    public void destroy() {
//        // Método de limpieza, si es necesario
//    }
//}
