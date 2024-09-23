package com.challenge.Cliente_persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.challenge.Cliente_persona.model.entity") 
public class ClientePersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientePersonaApplication.class, args);
	}

}
