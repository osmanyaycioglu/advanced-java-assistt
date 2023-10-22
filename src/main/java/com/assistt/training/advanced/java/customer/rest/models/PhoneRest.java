package com.assistt.training.advanced.java.customer.rest.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class PhoneRest {

    private String phoneName;
    private String phoneNumber;
    

}
