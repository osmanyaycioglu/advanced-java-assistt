package com.assistt.training.advanced.java.customer.services;

import com.assistt.training.advanced.java.customer.db.CustomerDBService;
import com.assistt.training.advanced.java.customer.db.ICustomerDao;
import com.assistt.training.advanced.java.customer.services.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequiredArgsConstructor
public class CustomerProvisionService {

    private final CustomerDBService customerDBService;

    public void addCustomer(Customer customerParam){
        customerDBService.insertCustomer(customerParam);
    }

}
