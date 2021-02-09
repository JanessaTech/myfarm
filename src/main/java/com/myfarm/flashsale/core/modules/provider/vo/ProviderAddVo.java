package com.myfarm.flashsale.core.modules.provider.vo;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel
public class ProviderAddVo {
    @ApiModelProperty(value = "供应商名称。供应商名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", required = true, example = "provider1234")
    @NotNull(message = "供应商名称不能为null")
    @NotBlank(message = "供应商名称不能为空字符串")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "供应商名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String name;

    @ApiModelProperty(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", required = true, example = "15319401521")
    @NotNull(message = "电话不能为null")
    @NotBlank(message = "电话不能为空字符串")
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确！")
    private String telPhone;

    @ApiModelProperty(value = "地址。地址规则：4到100位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,100}$", required = true, example = "shanxi_xian_changle_street_168")
    @NotNull(message = "地址不能为null")
    @NotBlank(message = "地址不能为空字符串")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,100}$", message = "地址只能包含字母，数字，下划线，减号且长度在4-100")
    private String address;

    @ApiModelProperty(value = "营业状态", required = true, example = "In_business")
    @NotNull(message = "营业状态不能为null")
    @NotBlank(message = "营业状态不能为空字符串")
    @EnumValueValidator(enumClass = Constants.ProviderStatus.class, message = "不是枚举有效值")
    private String operatingStatus;

    @ApiModelProperty(value = "营业执照", required = true, example = "www.baidu.com/111.jpg")
    private String picUrl;

    @ApiModelProperty(value = "备注", example = "testtesttest")
    private String comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
