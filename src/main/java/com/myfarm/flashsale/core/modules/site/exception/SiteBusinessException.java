package com.myfarm.flashsale.core.modules.site.exception;

public class SiteBusinessException extends Exception{
    public SiteBusinessException(String msg){
        super(msg);
    }
    public SiteBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
