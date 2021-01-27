package com.myfarm.flashsale.core.modules.user.exception;

public class UserProfileParameterException extends Exception{
    public UserProfileParameterException(String msg){
        super(msg);
    }
    public UserProfileParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
