package com.myfarm.flashsale.core.modules.audit.exception;

public class AuditParameterException extends Exception{
    public AuditParameterException(String msg){
        super(msg);
    }
    public AuditParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
