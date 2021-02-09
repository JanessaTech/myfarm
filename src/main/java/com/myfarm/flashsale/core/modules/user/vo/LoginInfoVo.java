package com.myfarm.flashsale.core.modules.user.vo;

import com.myfarm.flashsale.core.security.domain.Token;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LoginInfoVo {
    @ApiModelProperty(value = "token信息")
    private Token token;
    @ApiModelProperty(value = "用户ID")
    private String userId;

    public LoginInfoVo(Token token, String userId){
        this.token = token;
        this.userId = userId;
    }

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
