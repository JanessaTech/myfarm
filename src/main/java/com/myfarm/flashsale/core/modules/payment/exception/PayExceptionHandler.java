package com.myfarm.flashsale.core.modules.payment.exception;

import com.myfarm.flashsale.core.exception.GlobalExceptionHandler;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PayExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(value = PaymentParameterException.class)
    public ResponseEntity exception(PaymentParameterException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PaymentBusinessException.class)
    public ResponseEntity exception(PaymentBusinessException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = PaymentNotFoundException.class)
    public ResponseEntity exception(PaymentNotFoundException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
