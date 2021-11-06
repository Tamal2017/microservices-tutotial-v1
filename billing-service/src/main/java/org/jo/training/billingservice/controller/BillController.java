package org.jo.training.billingservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jo.training.billingservice.entity.Bill;
import org.jo.training.billingservice.feign.CustomerServiceClient;
import org.jo.training.billingservice.feign.ProductServiceClient;
import org.jo.training.billingservice.repository.BillRepository;
import org.jo.training.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@AllArgsConstructor
public class BillController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    private ProductServiceClient productServiceClient;

    @GetMapping("/fullBills/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.readCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productServiceClient.readProductById(productItem.getId()));
        });
        return bill;
    }

}
