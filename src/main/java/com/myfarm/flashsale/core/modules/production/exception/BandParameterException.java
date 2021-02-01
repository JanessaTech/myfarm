package com.myfarm.flashsale.core.modules.production.exception;

public class BandParameterException extends Exception{
    public BandParameterException(String msg){
        super(msg);
    }
    public BandParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
