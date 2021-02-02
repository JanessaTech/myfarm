package com.myfarm.flashsale.core.modules.order.exception;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String msg){
        super(msg);
    }
    public OrderNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
