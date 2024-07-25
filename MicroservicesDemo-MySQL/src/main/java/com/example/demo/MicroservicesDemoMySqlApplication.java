package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo.controller", "com.example.demo.services", "com.example.demo.beans"})
public class MicroservicesDemoMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesDemoMySqlApplication.class, args);
	}

}
