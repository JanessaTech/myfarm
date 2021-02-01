package com.myfarm.flashsale.core.modules.production.exception;

public class CategoryParameterException extends Exception{
    public CategoryParameterException(String msg){
        super(msg);
    }
    public CategoryParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
