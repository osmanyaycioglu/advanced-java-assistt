package com.assistt.training.advanced.java.customer.db;

import com.assistt.training.advanced.java.customer.services.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDBService {

    @Autowired
    private ICustomerDao customerDao;

    public void insertCustomer(Customer customerParam){
        customerDao.save(customerParam);
    }

}
