package com.projeto.biblioteca_digital;

import com.projeto.biblioteca_digital.security.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BibliotecaDigitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaDigitalApplication.class, args);
	}

}
