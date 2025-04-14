package br.com.rpg.personagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class PersonagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonagemApplication.class, args);
	}

}
