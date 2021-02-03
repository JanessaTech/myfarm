package com.myfarm.flashsale.core.modules.cart.dto;

import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

@ApiModel
public class CartDto {
    @ApiModelProperty(value = "购物车详情ID。符合UUID格式。参考：http://www.uuid.online ", example = "64a3b5a2-69e8-4544-bb26-3b17507d9992")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String cartItemId;

    @ApiModelProperty(value = "商品ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String productionId;

    @ApiModelProperty(value = "数量", example = "1")
    @Range(min = 0, message = "数量不能小于0")
    private Integer quantity;

    @ApiModelProperty(value = "加入购物车的时间。主要用来对购物车里的商品进行排序", example = "2021.01.12 13:21:77")
    private String addCartDate;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
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
