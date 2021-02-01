package com.myfarm.flashsale.core.modules.production.exception;

public class CategoryBusinessException extends Exception{
    public CategoryBusinessException(String msg){
        super(msg);
    }
    public CategoryBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
