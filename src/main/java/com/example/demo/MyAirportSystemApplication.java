package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAirportSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAirportSystemApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
	return (args) -> {..........}
	*/
	
}
