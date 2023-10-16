package com.facility;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition
@SpringBootApplication
@ComponentScan(basePackages = {"com.facility", "com.shared.interceptors", "com.shared.exception"})
public class FacilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacilityApplication.class, args);
	}

}