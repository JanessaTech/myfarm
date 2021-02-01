package com.myfarm.flashsale.core.modules.audit.exception;

public class AuditNotFoundException extends Exception{
    public AuditNotFoundException(String msg){
        super(msg);
    }
    public AuditNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
