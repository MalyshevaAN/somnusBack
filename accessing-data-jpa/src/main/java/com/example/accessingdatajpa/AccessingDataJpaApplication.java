package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	@Bean
	public CommandLineRunner demo (CustomerRepository repository){

		return args -> {
			//save customers
			repository.save(new Customer("Jack","Bauer"));
			repository.save(new Customer("Nastia", "Kreker"));
			repository.save(new Customer("Milana", "Kulich"));
			//fetch all customers
			log.info("Customers found with findAll():");
			log.info("----------------------");
			for (Customer customer : repository.findAll()){
				log.info(customer.toString());
			}
			log.info("");
			//fetch an individual
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L)");
			log.info("------------------------");
			log.info(customer.toString());
			log.info("");
			//by surname
			log.info("Customer found with findBySurname('Bauer'):");
			log.info("______________________________________");
			repository.findByName("Nastia").forEach(x -> System.out.println(x.toString()));
			log.info("");

		};
	}
}
