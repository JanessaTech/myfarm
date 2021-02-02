package com.myfarm.flashsale.core.modules.order.exception;

import com.myfarm.flashsale.core.exception.GlobalExceptionHandler;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(value = OrderParameterException.class)
    public ResponseEntity exception(OrderParameterException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity exception(OrderNotFoundException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderBusinessException.class)
    public ResponseEntity exception(OrderBusinessException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
}
