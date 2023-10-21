package com.assistt.training.advanced.java.customer.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDesc(exp.getMessage())
                       .withErrorCode(10100)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorDesc("Validation error")
                       .withErrorCode(10100)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(se -> ErrorObj.builder()
                                                            .withErrorDesc(se.getDefaultMessage())
                                                            .withErrorCode(10101)
                                                            .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleError(Exception exp) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                             .header("errorClass",
                                     exp.getClass()
                                        .getName())
                             .body(ErrorObj.builder()
                                           .withErrorDesc(exp.getMessage())
                                           .withErrorCode(10100)
                                           .build())
                ;
    }


}
