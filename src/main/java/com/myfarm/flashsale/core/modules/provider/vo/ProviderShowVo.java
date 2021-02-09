package com.myfarm.flashsale.core.modules.provider.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProviderShowVo {
    @ApiModelProperty(value = "供应商ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    private String providerId;

    @ApiModelProperty(value = "供应商名称。供应商名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", example = "provider1234")
    private String name;

    @ApiModelProperty(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$",  example = "15319401521")
    private String telPhone;

    @ApiModelProperty(value = "地址。地址规则：4到100位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,100}$",example = "shanxi_xian_changle_street_168")
    private String address;

    @ApiModelProperty(value = "营业状态", example = "In_business")
    private String operatingStatus;

    @ApiModelProperty(value = "营业执照", required = true, example = "www.baidu.com/111.jpg")
    private String picUrl;

    @ApiModelProperty(value = "备注", example = "testtesttest")
    private String comments;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

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
