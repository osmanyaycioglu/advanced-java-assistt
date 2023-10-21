package com.assistt.training.advanced.java.customer.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {NotContainsImpl.class}
)

public @interface NotContains {

    String[] value();

    String message() default "{javax.validation.constraints.NotContains.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
