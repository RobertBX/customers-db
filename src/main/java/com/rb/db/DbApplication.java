package com.rb.db;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DbApplication.class, args);
		 CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

		 Customer customer = new Customer();

		 customer.setFirstName("Adam");
		 customer.setLastName("Tred");
		 customer.setEmail("fdsfds@o2.pl");
		 customer.setPhone("5353");
		 customer.setId(2543l);

		 customerRepository.save(customer);

		System.out.println( customerRepository.findAll());
	}
}
