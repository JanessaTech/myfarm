package com.myfarm.flashsale.core.modules.audit.exception;

public class AuditBusinessException extends Exception{
    public AuditBusinessException(String msg){
        super(msg);
    }
    public AuditBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
