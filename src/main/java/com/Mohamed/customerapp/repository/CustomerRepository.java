package com.Mohamed.customerapp.repository;

import com.Mohamed.customerapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
