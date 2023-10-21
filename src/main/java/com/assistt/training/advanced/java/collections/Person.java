package com.assistt.training.advanced.java.collections;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@Builder(setterPrefix = "with")
public class Person {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 15,message = "isim 2 ile 15 arasında olmalı")
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 15,message = "isim 2 ile 15 arasında olmalı")
    private String surname;
    @Max(150)
    @Min(10)
    private Integer age;

}
