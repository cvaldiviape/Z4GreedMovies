package com.catalogs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

// "@EnableDiscoveryClient": habilita la funcionalidad de descubrimiento de servicios de Eureka. Eureka es un servicio de descubrimiento de servicios que permite a los servicios
// de la aplicación registrarse en él y descubrir y comunicarse con otros servicios que están registrados.
@EnableDiscoveryClient
@EnableFeignClients // habilitando todos los clientes Feing de mi proyecto, además de permitir la inyección de ese cliente.
@OpenAPIDefinition
@SpringBootApplication
@ComponentScan(basePackages = {"com.catalogs", "com.shared.interceptors", "com.shared.exception"})
public class CatalogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class, args);
	}

}