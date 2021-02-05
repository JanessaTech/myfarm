package com.myfarm.flashsale.core.modules.user.exception;

import com.myfarm.flashsale.core.exception.GlobalExceptionHandler;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(value = UserProfileParameterException.class)
    public ResponseEntity exception(UserProfileParameterException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserProfileNotFoundException.class)
    public ResponseEntity exception(UserProfileNotFoundException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserProfileBusinessException.class)
    public ResponseEntity exception(UserProfileBusinessException ex) {
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = LoginAuth2Exception.class)
    public ResponseEntity exception(LoginAuth2Exception ex) {
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }



    @ExceptionHandler(value = UserRoleParameterException.class)
    public ResponseEntity exception(UserRoleParameterException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserRoleNotFoundException.class)
    public ResponseEntity exception(UserRoleNotFoundException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserRoleBusinessException.class)
    public ResponseEntity exception(UserRoleBusinessException ex){
        FarmResponse response = FarmResponse.fail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

}
