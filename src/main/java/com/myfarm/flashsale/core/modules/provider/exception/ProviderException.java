package com.myfarm.flashsale.core.modules.provider.exception;

public class ProviderException extends Exception{
    public ProviderException(String msg){
        super(msg);
    }
    public ProviderException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
