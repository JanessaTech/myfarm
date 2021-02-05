package com.myfarm.flashsale.core.modules.id.exception;

public class IdException extends Exception{
    public IdException(String msg){
        super(msg);
    }
    public IdException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
