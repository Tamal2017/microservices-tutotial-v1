package org.jo.training.billingservice.feign;

import org.jo.training.billingservice.wrapperclass.CustomerWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {

    @GetMapping("/customers/{id}")
    CustomerWrapper readCustomerById(@PathVariable("id") Long id);
}
