package com.myfarm.flashsale.core.modules.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<UUIDValueValidator, String> {
    private String message;
    @Override
    public void initialize(UUIDValueValidator constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean valid = true;
        if(value != null){
            try{
                UUID.fromString(value);
            }catch (IllegalArgumentException ex){
                valid = false;
            }
        }else{
            valid = true;
        }

        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }
        return valid;
    }
}
