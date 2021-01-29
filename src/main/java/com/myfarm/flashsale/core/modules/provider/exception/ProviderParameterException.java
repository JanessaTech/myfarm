package com.myfarm.flashsale.core.modules.provider.exception;

public class ProviderParameterException extends Exception {
    public ProviderParameterException(String msg){
        super(msg);
    }
    public ProviderParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
