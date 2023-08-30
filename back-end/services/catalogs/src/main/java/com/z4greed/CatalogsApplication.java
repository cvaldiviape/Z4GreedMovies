package com.z4greed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// "@EnableEurekaClient": habilita la funcionalidad de descubrimiento de servicios de Eureka. Eureka es un servicio de descubrimiento de servicios que permite a los servicios
// de la aplicación registrarse en él y descubrir y comunicarse con otros servicios que están registrados.
@EnableEurekaClient
@EnableFeignClients // habilitando todos los clientes Feing de mi proyecto, además de permitir la inyección de ese cliente.
@SpringBootApplication
public class CatalogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class, args);
	}

}
