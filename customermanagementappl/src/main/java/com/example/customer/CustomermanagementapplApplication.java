package com.example.customer;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})

public class CustomermanagementapplApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomermanagementapplApplication.class, args);
		System.out.println("Soumya , Manasa");
	}
	 

}
