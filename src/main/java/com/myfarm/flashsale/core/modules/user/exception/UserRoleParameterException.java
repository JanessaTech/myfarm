package com.myfarm.flashsale.core.modules.user.exception;

public class UserRoleParameterException extends Exception{
    public UserRoleParameterException(String msg){
        super(msg);
    }
    public UserRoleParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
