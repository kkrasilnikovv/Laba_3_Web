package com.example.Laba_3_Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Laba3WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Laba3WebApplication.class, args);
	}

}
