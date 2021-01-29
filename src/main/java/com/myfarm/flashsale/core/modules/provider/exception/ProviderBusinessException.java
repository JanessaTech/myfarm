package com.myfarm.flashsale.core.modules.provider.exception;

public class ProviderBusinessException extends Exception{
    public ProviderBusinessException(String msg){
        super(msg);
    }
    public ProviderBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
