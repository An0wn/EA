package com.mum.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAutoConfiguration
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={
		"com.mum.controller",
		"com.mum.DAO",
		"com.mum.model",
		"com.mum.service",
		"com.mum.config",
		"com.mum.validator",
		"com.mum.security"})
@SpringBootApplication
public class EaKitchenClientApplication {

	public static int logginInUserId=1;
	
	public static void main(String[] args) {
		SpringApplication.run(EaKitchenClientApplication.class, args);
	}   
}
