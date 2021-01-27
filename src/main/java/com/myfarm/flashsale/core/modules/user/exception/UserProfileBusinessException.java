package com.myfarm.flashsale.core.modules.user.exception;

public class UserProfileBusinessException extends Exception{
    public UserProfileBusinessException(String msg){
        super(msg);
    }
    public UserProfileBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
