package com.myfarm.flashsale.core.modules.site.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class SiteParameterException extends Exception {
    public SiteParameterException(String msg){
        super(msg);
    }
    public SiteParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
