package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// Save for customers
			repository.save(new Customer("Saieshwar", "Bobbili"));
			repository.save(new Customer("prabhakar", "Gaddam"));
			repository.save(new Customer("Akhil", "shetty"));
			
			log.info("Customers found with findAll():");
		      log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info(" ");
			
			Customer customer = repository.findById(2L);
			log.info("Customer found with findById(2L):");
		      log.info("--------------------------------");
		      log.info(customer.toString());
		      log.info("");
		      
		      log.info("Customer by lastName:");
		       repository.findByLastName("Gaddam").forEach(gaddam->{
		    	   log.info(gaddam.toString());
		       });
		     
		      log.info("");
			
		};
	}
}
