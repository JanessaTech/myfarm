package com.myfarm.flashsale.core.security.exception;

public class TokenException extends Exception{
    public TokenException(String msg){
        super(msg);
    }
    public TokenException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
