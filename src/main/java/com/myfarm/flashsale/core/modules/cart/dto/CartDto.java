package com.myfarm.flashsale.core.modules.cart.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CartDto {
    private String cartItemId;
    private String userId;
    private String productionId;
    private Integer quantity;
    private String addCartDate;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
