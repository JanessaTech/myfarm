package com.myfarm.flashsale.core.modules.payment.controller;

import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.payment.dto.PaymentDto;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentBusinessException;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentNotFoundException;
import com.myfarm.flashsale.core.modules.payment.exception.PaymentParameterException;
import com.myfarm.flashsale.core.modules.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Api(value = "支付相关", tags = "payment")
@Validated
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "存储支付成功后的支付信息",
            notes = "【前端】【农菜鲜收银台】页面支付成功后调用该接口")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"})
    public FarmResponse<String> createPayment(@RequestBody(required = true) @Valid PaymentDto paymentDto) throws PaymentParameterException, PaymentBusinessException, PaymentNotFoundException{

        //code
        return null;
    }
}
