package com.assistt.training.advanced.java.customer.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotContainsImpl implements ConstraintValidator<NotContains,String> {

    private NotContains anno;

    @Override
    public void initialize(final NotContains constraintAnnotation) {
        this.anno = constraintAnnotation;
    }

    @Override
    public boolean isValid(final String stringParam,
                           final ConstraintValidatorContext constraintValidatorContextParam) {
        String[] valueLoc = anno.value();
        for (String notPermittedStrs : valueLoc) {
            if (stringParam.contains(notPermittedStrs)){
                return false;
            }
        }
        return true;
    }
}
