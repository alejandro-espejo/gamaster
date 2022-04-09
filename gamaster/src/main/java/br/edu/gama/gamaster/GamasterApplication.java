package br.edu.gama.gamaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamasterApplication.class, args);

		System.out.println("ola");
	}

}
