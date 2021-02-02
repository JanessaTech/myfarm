package com.myfarm.flashsale.core.modules.payment.dto;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "支付详情")
public class PaymentDto {
    @ApiModelProperty(value = "支付ID。符合UUID格式。参考：http://www.uuid.online ", example = "ec2f8761-2a6d-4bb9-a82d-b4490dadd459")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String paymentId;

    @ApiModelProperty(value = "支付方式", required = true, example = "weichat")
    @NotNull(message = "支付方式不能为null")
    @NotBlank(message = "支付方式不能为空值")
    @EnumValueValidator(enumClass = Constants.PayWay.class, message = "不是有效枚举值")
    private String payment;

    @ApiModelProperty(value = "支付号", required = true, example = "12345687890021zx")
    @NotNull(message = "支付号不能为null")
    @NotBlank(message = "支付号不能为空值")
    private String payno;


    @ApiModelProperty(value = "支付时间", required = true, example = "2021-01-13  14:15:05")
    //此处应该添加时间类型的字符串校验
    private String createDate;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
