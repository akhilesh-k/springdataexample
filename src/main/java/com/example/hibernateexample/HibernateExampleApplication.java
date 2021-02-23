package com.example.hibernateexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HibernateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateExampleApplication.class, args);
	}

}
