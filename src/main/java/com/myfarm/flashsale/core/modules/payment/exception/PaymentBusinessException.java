package com.myfarm.flashsale.core.modules.payment.exception;

public class PaymentBusinessException extends Exception{
    public PaymentBusinessException(String msg){
        super(msg);
    }
    public PaymentBusinessException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
