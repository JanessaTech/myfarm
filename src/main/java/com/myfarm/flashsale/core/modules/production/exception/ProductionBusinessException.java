package com.myfarm.flashsale.core.modules.production.exception;

public class ProductionBusinessException extends Exception{
    public ProductionBusinessException(String msg){
        super(msg);
    }
    public ProductionBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
