package com.example.MADProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MadProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadProjectApplication.class, args);
	}

}
