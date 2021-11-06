package org.jo.training.billingservice;

import org.jo.training.billingservice.entity.Bill;
import org.jo.training.billingservice.entity.ProductItem;
import org.jo.training.billingservice.feign.CustomerServiceClient;
import org.jo.training.billingservice.feign.ProductServiceClient;
import org.jo.training.billingservice.repository.BillRepository;
import org.jo.training.billingservice.repository.ProductItemRepository;
import org.jo.training.billingservice.wrapperclass.CustomerWrapper;
import org.jo.training.billingservice.wrapperclass.ProductWrapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.hateoas.PagedModel;

import java.time.LocalDateTime;
import java.util.List;

@Projection(name = "fullBill", types = Bill.class)
interface BillProjection {
    Long getId();

    Long getCustomerId();

    LocalDateTime getBillingDate();

    List<ProductItem> getProductItems();
}

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            CustomerServiceClient customerServiceClient, ProductServiceClient productServiceClient) {
        return args -> {
            CustomerWrapper customer = customerServiceClient.readCustomerById(1L);
            System.out.println("***********************************");
            System.out.println(customer);
            System.out.println("************************************");
            Bill bill = billRepository.save(new Bill(null, LocalDateTime.now(), customer.getId(), null, null));

            PagedModel<ProductWrapper> products = productServiceClient.readALlProducts();
            products.getContent().stream().limit(3).forEach(p -> {
                productItemRepository.save(new ProductItem(null, p.getId(), null,  p.getPrice(), p.getQuantity(), bill));
            });

        };
    }

}
