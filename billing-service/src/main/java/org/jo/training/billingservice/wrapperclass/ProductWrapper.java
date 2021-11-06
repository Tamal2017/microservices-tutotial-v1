package org.jo.training.billingservice.wrapperclass;

import lombok.Data;

@Data
public class ProductWrapper {
    private Long id;
    private String name;
    private Double quantity;
    private Double price;
}
