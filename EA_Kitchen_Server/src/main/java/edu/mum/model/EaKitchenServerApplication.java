package edu.mum.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={
		"edu.mum.controllers",
		"edu.mum.DAO",
		"edu.mum.model",
		"edu.mum.service"})
@EnableJpaRepositories("edu.mum.DAO")
public class EaKitchenServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaKitchenServerApplication.class, args);
	}
}
