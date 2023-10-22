package com.assistt.training.advanced.java.customer.services.models;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long addId;
    private String city;
    private String street;

}
