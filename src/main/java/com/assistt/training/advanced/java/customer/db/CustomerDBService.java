package com.assistt.training.advanced.java.customer.db;

import com.assistt.training.advanced.java.customer.services.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerDBService {

    private final ICustomerDao customerDao;

    @Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.READ_UNCOMMITTED)
    public void insertCustomer(Customer customerParam) {
        customerDao.save(customerParam); // T1
        customerDao.save(customerParam); // T2
    }

}
