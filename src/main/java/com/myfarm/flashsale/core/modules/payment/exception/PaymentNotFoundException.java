package com.myfarm.flashsale.core.modules.payment.exception;

public class PaymentNotFoundException extends Exception{
    public PaymentNotFoundException(String msg){
        super(msg);
    }
    public PaymentNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
