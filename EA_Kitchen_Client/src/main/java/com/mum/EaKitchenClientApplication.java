package com.mum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={
		"com.mum.controller",
		"com.mum.DAO",
		"com.mum.model",
		"com.mum.service",
		"com.mum.config"})
@SpringBootApplication
public class EaKitchenClientApplication {

	public static int logginInUserId=1;
	
	public static void main(String[] args) {
		SpringApplication.run(EaKitchenClientApplication.class, args);
	}   
}
