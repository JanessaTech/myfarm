package com.myfarm.flashsale.core.modules.order.exception;

public class OrderBusinessException extends Exception{
    public OrderBusinessException(String msg){
        super(msg);
    }
    public OrderBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
