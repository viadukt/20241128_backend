package com.example.basicSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring-Boot-Application, which serves as a REST-API for a SQLite-database.
 *
 * @author viadukt
 * @version 1.0
 */
@SpringBootApplication
public class BasicSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringBootApplication.class, args);
	}

}
