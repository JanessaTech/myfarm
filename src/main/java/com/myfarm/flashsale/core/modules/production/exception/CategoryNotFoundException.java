package com.myfarm.flashsale.core.modules.production.exception;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String msg){
        super(msg);
    }
    public CategoryNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
