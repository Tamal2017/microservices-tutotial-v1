package org.jo.training.customerservice;

import org.jo.training.customerservice.entity.Customer;
import org.jo.training.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration) {
       return  args -> {
           restConfiguration.exposeIdsFor(Customer.class);
           customerRepository.save(new Customer(null, "Joseph", "test@mail.com"));
           customerRepository.save(new Customer(null, "Client A", "test@test.com"));
           customerRepository.save(new Customer(null, "Client B", "mail@mail.fr"));
       };
    }

}
