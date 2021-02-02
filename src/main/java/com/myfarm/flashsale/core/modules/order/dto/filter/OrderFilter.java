package com.myfarm.flashsale.core.modules.order.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

@ApiModel
public class OrderFilter {
    @ApiModelProperty(value = "订单ID。符合UUID格式。参考：http://www.uuid.online ", example = "ec2f8761-2a6d-4bb9-a82d-b4490dadd459")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String orderId;

    @ApiModelProperty(value = "下单用户ID。符合UUID格式。参考：http://www.uuid.online ", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String userId;

    @ApiModelProperty(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", example = "15824657732")
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确！")
    private String telPhone;

    @ApiModelProperty(value = "收货人。用户名规则：4到16位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,16}$", example = "zhaojuan")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "收货人只能包含字母，数字，下划线，减号，且长度在4-16之间")
    private String receiver;

    @ApiModelProperty(value = "订单创建起始时间", example = "2021-01-13  00:00:00")
    private String startDateCreateOrder;

    @ApiModelProperty(value = "订单创建结束时间", example = "2021-01-13  24:00:00")
    private String endDateCreateOrder;

    @ApiModelProperty(value = "订单状态。有效值为：Waiting_for_pay, Waiting_for_fetch, fetched, close", example = "Waiting_for_pay")
    @EnumValueValidator(enumClass = Constants.OrderStatus.class,message = "不是有效枚举值")
    private String status;

    @ApiModelProperty(value = "待排序的列名。默认为键值列", example = "order_id")
    private String orderBy = "order_id";

    @ApiModelProperty(value = "升序还是降序排序。有效枚举值：ASC, DESC", example = "ASC")
    @EnumValueValidator(enumClass = Constants.Order.class, message = "不是枚举有效值")
    private String order = Constants.Order.ASC.getCode();

    @ApiModelProperty(value = "是否包含商品详细信息")
    private boolean includeDetail = false;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getStartDateCreateOrder() {
        return startDateCreateOrder;
    }

    public void setStartDateCreateOrder(String startDateCreateOrder) {
        this.startDateCreateOrder = startDateCreateOrder;
    }

    public String getEndDateCreateOrder() {
        return endDateCreateOrder;
    }

    public void setEndDateCreateOrder(String endDateCreateOrder) {
        this.endDateCreateOrder = endDateCreateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isIncludeDetail() {
        return includeDetail;
    }

    public void setIncludeDetail(boolean includeDetail) {
        this.includeDetail = includeDetail;
    }
}
