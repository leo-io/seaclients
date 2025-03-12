package com.sea.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sea.clients.repository")

public class SeaClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaClientsApplication.class, args);
	}

}
