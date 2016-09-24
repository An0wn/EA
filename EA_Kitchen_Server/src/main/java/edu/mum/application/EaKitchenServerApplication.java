package edu.mum.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={
		"edu.mum.controllers",
		"edu.mum.DAO",
		"edu.mum.model",
		"edu.mum.service"})
@SpringBootApplication
public class EaKitchenServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaKitchenServerApplication.class, args);
	}
}
