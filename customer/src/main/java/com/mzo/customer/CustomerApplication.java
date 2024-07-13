package com.mzo.customer;

import com.mzo.customer.entity.Customer;
import com.mzo.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return  args -> {
		customerRepository.save(Customer.builder().firstName("Mohamed").lastName("Zorgani").email("mohamed@gmail.com")
				.build());
			customerRepository.save(Customer.builder().firstName("Ali").lastName("Bouali").email("bouali@gmail.com")
					.build());
			customerRepository.save(Customer.builder().firstName("Amed").lastName("Ahmed").email("ahmed@gmail.com")
					.build());

		};
	}

}
