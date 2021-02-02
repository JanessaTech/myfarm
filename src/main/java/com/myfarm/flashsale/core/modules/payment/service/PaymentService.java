package com.myfarm.flashsale.core.modules.payment.service;

import com.myfarm.flashsale.core.modules.payment.dto.PaymentDto;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentBusinessException;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentNotFoundException;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentParameterException;

import java.util.List;

public interface PaymentService {
    /**
     *
     * @param paymentDto the payment information after paying successfully
     * @return payment_id
     * @throws PaymentParameterException
     * @throws PaymentBusinessException
     * @throws PaymentNotFoundException
     */
    String createPayment(PaymentDto paymentDto) throws PaymentParameterException, PaymentBusinessException, PaymentNotFoundException;
    List<PaymentDto> getPaymentByIds(List<String> paymentIds) throws PaymentParameterException, PaymentBusinessException, PaymentNotFoundException;
}
