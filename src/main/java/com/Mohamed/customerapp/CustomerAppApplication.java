package com.Mohamed.customerapp;

import com.Mohamed.customerapp.entities.Customer;
import com.Mohamed.customerapp.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"Mohamed","mohamed@gmail.com"));
			customerRepository.save(new Customer(null,"Redtha","redtha@gmail.com"));
			customerRepository.save(new Customer(null,"Malika","malika@gmail.com"));
		};
	}

}
