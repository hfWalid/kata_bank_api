package com.sg.soft.KataBankApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KataBankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KataBankAppApplication.class, args);
	}

	@Bean
	ModelMapper getModelMapper(){return new ModelMapper();}

}
