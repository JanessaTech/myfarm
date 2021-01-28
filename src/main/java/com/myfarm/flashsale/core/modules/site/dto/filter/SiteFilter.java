package com.myfarm.flashsale.core.modules.site.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

@ApiModel
public class SiteFilter {
    @ApiModelProperty(value = "自提店ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String siteId;

    @ApiModelProperty(value = "自提店名称。自提店名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", example = "zitidian1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "自提店名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String name;

    @ApiModelProperty(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", example = "15319401521")
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确！")
    private String telPhone;

    @ApiModelProperty(value = "营业状态", example = "In_business")
    @EnumValueValidator(enumClass = Constants.SiteStatus.class, message = "不是枚举有效值")
    private String operatingStatus;

    @ApiModelProperty(value = "团长。团长名规则：4到16位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,16}$", example = "tuanZhang123")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "团长名只能包含字母，数字，下划线，减号，且长度在4-16之间")
    private String leader;

    @ApiModelProperty(value = "", example = "site_id")
    private String orderBy = "site_id";


    @ApiModelProperty(value = "待排序的列名。默认为键值列", example = "ASC")
    @EnumValueValidator(enumClass = Constants.Order.class, message = "不是枚举有效值")
    private String order = Constants.Order.ASC.getCode();

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
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
