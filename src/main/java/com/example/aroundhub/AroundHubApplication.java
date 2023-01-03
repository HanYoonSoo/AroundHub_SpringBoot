package com.example.aroundhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class AroundHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AroundHubApplication.class, args);
	}

}
