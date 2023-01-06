package com.example.aroundhub;

import com.example.aroundhub.config.ProfileManager;
import com.example.aroundhub.config.env.EnvConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class AroundHubApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(AroundHubApplication.class);

	@Autowired
	public AroundHubApplication(EnvConfiguration envConfiguration, ProfileManager profileManager){
		LOGGER.info(envConfiguration.getMessage());
		profileManager.printActiveProfiles();
	}
	public static void main(String[] args) {
		SpringApplication.run(AroundHubApplication.class, args);
	}

}
