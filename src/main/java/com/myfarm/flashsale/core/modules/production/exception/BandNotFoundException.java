package com.myfarm.flashsale.core.modules.production.exception;

public class BandNotFoundException extends Exception{
    public BandNotFoundException(String msg){
        super(msg);
    }
    public BandNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
