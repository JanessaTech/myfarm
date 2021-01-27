package com.myfarm.flashsale.core.modules.user.exception;

public class UserRoleNotFoundException extends Exception{
    public UserRoleNotFoundException(String msg){
        super(msg);
    }
    public UserRoleNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
