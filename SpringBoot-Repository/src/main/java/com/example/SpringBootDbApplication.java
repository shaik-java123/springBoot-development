package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example")
/**
 * THIS IS THE MAIN CLASS
 */
public class SpringBootDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbApplication.class, args);
	}

}
