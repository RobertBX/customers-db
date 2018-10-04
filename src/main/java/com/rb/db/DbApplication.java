package com.rb.db;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DbApplication.class, args);
		 CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

	}
}
