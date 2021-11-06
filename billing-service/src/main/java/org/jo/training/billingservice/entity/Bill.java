package org.jo.training.billingservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jo.training.billingservice.wrapperclass.CustomerWrapper;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime billingDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long customerId;

    @Transient
    private CustomerWrapper customer;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
}
