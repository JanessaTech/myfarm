package com.myfarm.flashsale.core.modules.production.exception;

public class ProductionNotFoundException extends Exception{
    public ProductionNotFoundException(String msg){
        super(msg);
    }
    public ProductionNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
