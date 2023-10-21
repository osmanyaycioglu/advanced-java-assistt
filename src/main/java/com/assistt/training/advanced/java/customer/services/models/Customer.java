package com.assistt.training.advanced.java.customer.services.models;

import com.assistt.training.advanced.java.customer.validation.NotContains;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long   customerId;
    private String name;
    @Column(nullable = false)
    private String surname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
