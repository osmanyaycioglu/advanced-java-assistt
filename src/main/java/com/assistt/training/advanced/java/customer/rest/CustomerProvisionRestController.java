package com.assistt.training.advanced.java.customer.rest;


import com.assistt.training.advanced.java.customer.rest.error.ErrorObj;
import com.assistt.training.advanced.java.customer.rest.mappers.ICustomerMapper;
import com.assistt.training.advanced.java.customer.rest.models.CustomerRest;
import com.assistt.training.advanced.java.customer.services.CustomerProvisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer/provision")
//@RequestScope
@RequiredArgsConstructor
public class CustomerProvisionRestController {
    //@Autowired
    private final CustomerProvisionService customerProvisionService;

    @PostConstruct
    public void init() {
        System.out.println("init");
    }


    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerRest customerRestParam) {
        customerProvisionService.addCustomer(ICustomerMapper.mapper.toCustomer(customerRestParam));
        return "OK";
    }


}
