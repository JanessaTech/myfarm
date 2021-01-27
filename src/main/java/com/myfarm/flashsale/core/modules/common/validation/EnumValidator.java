package com.myfarm.flashsale.core.modules.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class EnumValidator implements ConstraintValidator<EnumValueValidator, String> {
    private Class<? extends Enum<?>> enumClass;
    private String enumMethod = "valueOf";
    @Override
    public void initialize(EnumValueValidator constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null)
            return false;

        Class<?> valueClass = value.getClass();

        try {
            Method method = enumClass.getMethod(enumMethod, valueClass);
            Object result = method.invoke(null, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
