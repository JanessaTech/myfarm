package com.myfarm.flashsale.core.modules.provider.exception;

public class ProviderNotFoundException extends Exception {
    public ProviderNotFoundException(String msg){
        super(msg);
    }
    public ProviderNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
