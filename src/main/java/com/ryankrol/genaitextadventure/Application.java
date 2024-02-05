package com.ryankrol.genaitextadventure;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// load the .env file variables into system properties
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

		SpringApplication.run(Application.class, args);
	}

	@Bean
	public InputStream inputStream() {
		return System.in;
	}

}
