package com.skcet.sem_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class SemLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemLabApplication.class, args);
	}

}
