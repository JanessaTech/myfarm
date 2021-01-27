package com.myfarm.flashsale.core.modules.user.exception;

public class UserRoleBusinessException extends Exception{
    public UserRoleBusinessException(String msg){
        super(msg);
    }
    public UserRoleBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
