package com.assistt.training.advanced.java.customer.rest.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class AddressRest {

    private String city;
    private String street;

}
