package com.assistt.training.advanced.java.customer.db;

import com.assistt.training.advanced.java.customer.services.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDBService {

    private final ICustomerDao customerDao;

    public void insertCustomer(Customer customerParam){
        customerDao.save(customerParam);
    }

}
