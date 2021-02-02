package com.myfarm.flashsale.core.modules.cart.exception;

public class CartParameterException extends Exception{
    public CartParameterException(String msg){
        super(msg);
    }
    public CartParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
