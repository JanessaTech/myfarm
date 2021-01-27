package com.myfarm.flashsale.core.modules.user.exception;

public class UserProfileNotFoundException extends Exception{
    public UserProfileNotFoundException(String msg){
        super(msg);
    }
    public UserProfileNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
