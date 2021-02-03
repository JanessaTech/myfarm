package com.myfarm.flashsale.core.modules.cart.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CartFilter {
    @ApiModelProperty(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    String userId;

    @ApiModelProperty(value = "待删除的购物车的条目。有多个条目需要删除时，把各条目的cartItemId用','连接起来。cartItemIds必须符合UUID格式", example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
    @MultipleUUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    String cartItemIds;

    @ApiModelProperty(value = "待排序的列名。", example = "add_Cart_date")
    private String orderBy = "add_Cart_date";

    @ApiModelProperty(value = "升序还是降序排序。有效枚举值：ASC, DESC", example = "ASC")
    @EnumValueValidator(enumClass = Constants.Order.class, message = "不是枚举有效值")
    private String order = Constants.Order.DESC.getCode();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCartItemIds() {
        return cartItemIds;
    }

    public void setCartItemIds(String cartItemIds) {
        this.cartItemIds = cartItemIds;
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
}
