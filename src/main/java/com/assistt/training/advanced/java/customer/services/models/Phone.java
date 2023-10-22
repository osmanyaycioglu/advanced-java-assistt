package com.assistt.training.advanced.java.customer.services.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long phoneId;
    private String phoneName;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Customer customer;


}
