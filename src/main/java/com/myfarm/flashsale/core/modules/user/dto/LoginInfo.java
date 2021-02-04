package com.myfarm.flashsale.core.modules.user.dto;

import com.myfarm.flashsale.core.modules.common.Token;
import io.swagger.annotations.ApiModel;

@ApiModel
public class LoginInfo {
    private Token token;
    private String userId;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
