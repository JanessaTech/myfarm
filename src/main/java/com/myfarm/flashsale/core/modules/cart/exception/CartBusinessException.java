package com.myfarm.flashsale.core.modules.cart.exception;

public class CartBusinessException extends Exception{
    public CartBusinessException(String msg){
        super(msg);
    }
    public CartBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
