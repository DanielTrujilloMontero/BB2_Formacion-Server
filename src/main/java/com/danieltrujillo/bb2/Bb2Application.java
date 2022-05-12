package com.danieltrujillo.bb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Bb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bb2Application.class, args);
		//spring.datasource.url=jdbc:h2:mem:db
	}

}
