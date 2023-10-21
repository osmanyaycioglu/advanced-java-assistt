package com.assistt.training.advanced.java.customer.rest.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String  errorDesc;
    private Integer errorCode;

    public ErrorObj() {
    }
}
