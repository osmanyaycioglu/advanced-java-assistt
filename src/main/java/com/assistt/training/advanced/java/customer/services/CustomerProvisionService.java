package com.assistt.training.advanced.java.customer.services;

import com.assistt.training.advanced.java.customer.db.CustomerDBService;
import com.assistt.training.advanced.java.customer.db.ICustomerDao;
import com.assistt.training.advanced.java.customer.services.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerProvisionService {

    @Autowired
    private CustomerDBService customerDBService;

    public void addCustomer(Customer customerParam){

    }

}
