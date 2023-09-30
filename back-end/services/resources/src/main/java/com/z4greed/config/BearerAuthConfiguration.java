//package com.z4greed.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import feign.RequestInterceptor;
//
//import java.util.Collection;
//
//public class BearerAuthConfiguration {
//
//    @Bean
//    public RequestInterceptor bearerAuthRequestInterceptor() {
//        return requestTemplate -> {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (authentication != null) {
////                Object details = authentication.getDetails();
////                String token = "Bearer " + String.valueOf(details);
////                requestTemplate.header(HttpHeaders.AUTHORIZATION, token);
//                Object principal = authentication.getPrincipal();
//                Object details1 = authentication.getDetails();
//                String name = authentication.getName();
//                Object credentials = authentication.getCredentials();
//                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//
//                String token = "Bearer " + String.valueOf(principal);
//                requestTemplate.header(HttpHeaders.AUTHORIZATION, token);
//            }
//        };
//    }
//
//}
