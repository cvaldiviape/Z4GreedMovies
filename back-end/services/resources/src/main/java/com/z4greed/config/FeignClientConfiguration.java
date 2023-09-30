package com.z4greed.config;

//import feign.RequestInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//
//@Configuration
//public class FeignClientConfiguration {
//
//    @Autowired
//    private JwtTokenPropagatingInterceptor jwtTokenPropagatingInterceptor;
//
//    @Bean
//    public RequestInterceptor feignRequestInterceptor() {
//        return template -> {
//            // Asegúrate de que el usuario esté autenticado antes de aplicar el interceptor
//            if (jwtTokenPropagatingInterceptor.isEnabled()) {
//                jwtTokenPropagatingInterceptor.apply(template);
//            }
//        };
//    }
//}