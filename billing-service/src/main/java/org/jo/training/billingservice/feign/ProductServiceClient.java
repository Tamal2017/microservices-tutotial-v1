package org.jo.training.billingservice.feign;

import org.jo.training.billingservice.wrapperclass.ProductWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/products/{id}")
    ProductWrapper readProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    PagedModel<ProductWrapper> readALlProducts();
}
