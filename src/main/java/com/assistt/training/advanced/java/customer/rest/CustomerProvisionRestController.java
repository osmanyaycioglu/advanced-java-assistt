package com.assistt.training.advanced.java.customer.rest;


import com.assistt.training.advanced.java.customer.rest.error.ErrorObj;
import com.assistt.training.advanced.java.customer.rest.models.CustomerRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionRestController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerRest customerRestParam) {
        return "OK";
    }


}
