package com.myfarm.flashsale.core.modules.order.dto;

import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@ApiModel
public class OrderDetailDto {
    @ApiModelProperty(value = "订单详情ID。符合UUID格式。参考：http://www.uuid.online ", example = "64a3b5a2-69e8-4544-bb26-3b17507d9992")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String orderDetailId;

    @ApiModelProperty(value = "订单ID。符合UUID格式。参考：http://www.uuid.online ", example = "588572a7-d4ea-45a4-8bba-91c44c25c92b")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String orderId;

    @ApiModelProperty(value = "商品ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String productionId;

    @ApiModelProperty(value = "商品名称。商品名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$",required = true, example = "production1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "商品名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String title;

    @ApiModelProperty(value = "规格", required = true, example = "1斤/份  正负0.1斤")
    private String unit;

    @ApiModelProperty(value = "提货时间. format: yyyy.mm.dd", required = true, example = "2021.01.13")
    private String dateDelivery; //format: yyyy.mm.dd

    @ApiModelProperty(value = "价格", required = true, example = "1.1")
    private Double price;

    @ApiModelProperty(value = "原始价格",required = true, example = "2.3")
    private Double originalPrice;

    @ApiModelProperty(value = "商品图片", required = true)
    private String picUrl;

    @ApiModelProperty(value = "供应商。供应商名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$ <br> no need to fill when add, modify. Must fill when query", example = "provider1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "供应商名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String providerName;

    @ApiModelProperty(value = "数量", example = "1")
    @Range(min = 0, message = "数量不能小于0")
    private Integer quantity;

    @ApiModelProperty(value = "加入购物车的时间。主要用来对订单里的商品进行排序", example = "2021.01.12 13:21:77")
    private String addCartDate;

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAddCartDate() {
        return addCartDate;
    }

    public void setAddCartDate(String addCartDate) {
        this.addCartDate = addCartDate;
    }
}
