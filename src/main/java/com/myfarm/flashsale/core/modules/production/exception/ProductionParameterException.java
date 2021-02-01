package com.myfarm.flashsale.core.modules.production.exception;

public class ProductionParameterException extends Exception{
    public ProductionParameterException(String msg){
        super(msg);
    }
    public ProductionParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
