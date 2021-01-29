package com.myfarm.flashsale.core.modules.provider.exception;

import com.myfarm.flashsale.core.exception.GlobalExceptionHandler;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProviderExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(value = ProviderParameterException.class)
    public ResponseEntity exception(ProviderParameterException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProviderBusinessException.class)
    public ResponseEntity exception(ProviderBusinessException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ProviderNotFoundException.class)
    public ResponseEntity exception(ProviderNotFoundException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }


}
