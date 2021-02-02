package com.myfarm.flashsale.core.modules.payment.exception;

public class PaymentParameterException extends Exception{
    public PaymentParameterException(String msg){
        super(msg);
    }
    public PaymentParameterException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
