package com.ubigeo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@OpenAPIDefinition
@SpringBootApplication
@ComponentScan(basePackages = {"com.ubigeo", "com.shared.interceptors", "com.shared.exception"})
public class UbigeosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbigeosApplication.class, args);
	}

}
