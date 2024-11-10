package com.challenge.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The GatewayApplication class is the entry point for the Spring Boot application.
 * It is annotated with @SpringBootApplication, which signifies a configuration
 * class that declares one or more @Bean methods and also triggers auto-configuration
 * and component scanning. The class is also annotated with @EnableFeignClients,
 * enabling Feign clients in the application for remote procedure calls.
 *
 * The main method serves as the starting point of the application,
 * invoking SpringApplication.run() to launch the application.
 */
@SpringBootApplication
@EnableFeignClients
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
