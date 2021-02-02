package com.myfarm.flashsale.core.modules.order.dto;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import com.myfarm.flashsale.core.modules.payment.dto.PaymentDto;
import com.myfarm.flashsale.core.modules.site.dto.SiteDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.util.List;

@ApiModel
public class OrderDto {
    @ApiModelProperty(value = "订单ID。符合UUID格式。参考：http://www.uuid.online ", example = "ec2f8761-2a6d-4bb9-a82d-b4490dadd459")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String orderId;

    @ApiModelProperty(value = "下单用户ID。符合UUID格式。参考：http://www.uuid.online ", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String userId;

    @ApiModelProperty(value = "收货人。用户名规则：4到16位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,16}$", example = "zhaojuan")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "收货人只能包含字母，数字，下划线，减号，且长度在4-16之间")
    private String receiver;

    @ApiModelProperty(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", example = "15824657732")
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确！")
    private String telPhone;

    private SiteDto siteDto;

    @ApiModelProperty(value = "订单创建时间", example = "2021-01-13  14:15:05")
    private String createDate;

    @ApiModelProperty(value = "商品数量",example = "2")
    @Range(min = 0, message = "商品数量不能小于0")
    private Integer numberOfProd;

    @ApiModelProperty(value = "订单额", example = "5.78")
    private Double totalPay;

    @ApiModelProperty(value = "应付金额", example = "5.78")
    private Double actualPay;

    private PaymentDto paymentDto;

    @ApiModelProperty(value = "订单状态。有效值为：Waiting_for_pay, Waiting_for_fetch, fetched, close", example = "Waiting_for_pay")
    @EnumValueValidator(enumClass = Constants.OrderStatus.class,message = "不是有效枚举值")
    private String status;

    private List<OrderDetailDto> orderDetailDtoList;

}
