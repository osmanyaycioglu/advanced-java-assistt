package com.assistt.training.advanced.java.customer.rest.models;

import com.assistt.training.advanced.java.customer.validation.NotContains;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CustomerRest {
    @NotEmpty
    @Size(min = 2, max = 15)
    private String name;
    @NotEmpty
    @Size(min = 2, max = 15)
    private String surname;
    @NotEmpty
    @Size(min = 6, max = 12)
    @NotContains({"abc",
                  "-",
                  "xyz"
    })
    private String username;

    private String password;


}
