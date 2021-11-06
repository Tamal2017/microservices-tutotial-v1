package org.jo.training.productservice;

import org.jo.training.productservice.entity.Product;
import org.jo.training.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration) {
        return  args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.save(new Product(null, "Product 01", 15000.0, 450.0));
            productRepository.save(new Product(null, "Table", 15000.0, 50.0));
            productRepository.save(new Product(null, "Smart TV ", 805000.0, 10.0));
            productRepository.save(new Product(null, "Smart Phone 01", 1000.0, 100.0));
        };
    }

}
