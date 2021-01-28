package com.myfarm.flashsale.core.modules.site.exception;

public class SiteNotFoundException extends Exception{
    public SiteNotFoundException(String msg){
        super(msg);
    }
    public SiteNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
