package com.myfarm.flashsale.core.modules.production.exception;

public class BandBusinessException extends Exception{
    public BandBusinessException(String msg){
        super(msg);
    }
    public BandBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
