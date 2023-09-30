package com.z4greed.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenPropagatingInterceptor implements RequestInterceptor { // OK

    @Override
    public void apply(RequestTemplate template) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication instanceof JwtAuthenticationToken) {
            JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
            // Obtener el token JWT
            Jwt jwt = jwtToken.getToken();

            if (jwt != null) {
                String tokenValue = jwt.getTokenValue();
                template.header("Authorization", "Bearer " + tokenValue);
            }
        }
    }

}