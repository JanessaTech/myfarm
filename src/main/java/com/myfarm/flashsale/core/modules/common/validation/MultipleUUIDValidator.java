package com.myfarm.flashsale.core.modules.common.validation;

import com.github.pagehelper.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class MultipleUUIDValidator implements ConstraintValidator<MultipleUUIDValueValidator, String> {
    private String message;
    @Override
    public void initialize(MultipleUUIDValueValidator constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String uuids, ConstraintValidatorContext context) {
        if(StringUtil.isEmpty(uuids))
            return Boolean.FALSE;
        String[] uuidArr = uuids.split(",");
        try{
            for(String uuid : uuidArr){
                UUID.fromString(uuid);
            }
        }catch(Exception ex){
            //ex.printStackTrace();
            return false;
        }


        return true;
    }
}
