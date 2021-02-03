package com.myfarm.flashsale.core.modules.payment.service.imp;

import com.myfarm.flashsale.core.modules.payment.dto.PaymentDto;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentBusinessException;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentNotFoundException;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentParameterException;
import com.myfarm.flashsale.core.modules.payment.repository.mappers.PaymentMapper;
import com.myfarm.flashsale.core.modules.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayServiceImp implements PaymentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public String createPayment(PaymentDto paymentDto) throws PaymentParameterException, PaymentBusinessException, PaymentNotFoundException {
        return null;
    }

    @Override
    public List<PaymentDto> getPaymentByIds(List<String> paymentIds) throws PaymentParameterException, PaymentBusinessException, PaymentNotFoundException {
        return null;
    }
}
