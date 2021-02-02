package com.myfarm.flashsale.core.modules.cart.exception;

public class CartNotFoundException extends Exception{
    public CartNotFoundException(String msg){
        super(msg);
    }
    public CartNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
