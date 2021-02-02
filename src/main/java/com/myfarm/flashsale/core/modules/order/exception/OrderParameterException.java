package com.myfarm.flashsale.core.modules.order.exception;

public class OrderParameterException extends Exception{
    public OrderParameterException(String msg){
        super(msg);
    }
    public OrderParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
