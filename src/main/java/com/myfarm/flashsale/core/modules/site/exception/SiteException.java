package com.myfarm.flashsale.core.modules.site.exception;

public class SiteException extends Exception{
    public SiteException(String msg){
        super(msg);
    }
    public SiteException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
