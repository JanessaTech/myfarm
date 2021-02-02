package com.myfarm.flashsale.core.modules.cart.exception;

import com.myfarm.flashsale.core.exception.GlobalExceptionHandler;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(value = CartParameterException.class)
    public ResponseEntity exception(CartParameterException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CartNotFoundException.class)
    public ResponseEntity exception(CartNotFoundException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CartBusinessException.class)
    public ResponseEntity exception(CartBusinessException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
}
