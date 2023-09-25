//package com.z4greed.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {

//    @Override
//    public void configure(HttpSecurity httpSecurrity) throws Exception {
//        httpSecurrity.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt); // con esto garantizo que cualquier request que venga a "service catalogs" sera interceptado por este metodo "public void configure()"
//                                                                            // y sera validado por el mercanismo "OAuth2ResourceServer".
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/token/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
////                .httpBasic(Customizer.withDefaults())
//                .build();
//
////        httpSecurity.oauth2ResourceServer()
////                .jwt();
////
////        httpSecurity.sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
////        return httpSecurity.build();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .oauth2ResourceServer((oauth2) -> oauth2.jwt(jwt -> {}))
//                .build();
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return JwtDecoders.fromIssuerLocation("http://localhost:9090/realms/z4movies");
//    }

    // documentacion: https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html

//}
