package com.assistt.training.advanced.java.customer.db;

import com.assistt.training.advanced.java.customer.services.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDao extends JpaRepository<Customer,Long> {
}
