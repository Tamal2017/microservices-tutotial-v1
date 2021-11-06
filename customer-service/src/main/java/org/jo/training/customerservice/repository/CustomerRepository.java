package org.jo.training.customerservice.repository;

import org.jo.training.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
