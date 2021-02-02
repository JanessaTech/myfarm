package com.myfarm.flashsale.core.modules.order.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModelProperty;

public class OrderDetailFilter {
    @ApiModelProperty(value = "订单ID。符合UUID格式。参考：http://www.uuid.online ", example = "ec2f8761-2a6d-4bb9-a82d-b4490dadd459")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String orderId;

    @ApiModelProperty(value = "待排序的列名。默认为键值列", example = "order_detail_id")
    private String orderBy = "order_detail_id";

    @ApiModelProperty(value = "升序还是降序排序。有效枚举值：ASC, DESC", example = "ASC")
    @EnumValueValidator(enumClass = Constants.Order.class, message = "不是枚举有效值")
    private String order = Constants.Order.ASC.getCode();
}