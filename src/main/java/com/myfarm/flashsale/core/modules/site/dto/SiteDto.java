package com.myfarm.flashsale.core.modules.site.dto;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel(value = "自提店信息")
public class SiteDto {
    @ApiModelProperty(value = "自提店ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String siteId;

    @ApiModelProperty(value = "自提店名称。自提店名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", required = true, example = "zitidian1234")
    @NotNull(message = "自提店名称不能为null")
    @NotBlank(message = "自提店名称不能为空字符串")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,30}$", message = "自提店名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String name;

    @ApiModelProperty(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", required = true, example = "15319401521")
    @NotNull(message = "电话不能为null")
    @NotBlank(message = "电话不能为空字符串")
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确")
    private String telPhone;

    @ApiModelProperty(value = "地址。地址规则：4到100位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,100}$", required = true, example = "shanxi_xian_changle_street_168")
    @NotNull(message = "地址不能为null")
    @NotBlank(message = "地址不能为空字符串")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,100}$", message = "地址只能包含字母，数字，下划线，减号且长度在4-100")
    private String address;

    @ApiModelProperty(value = "营业状态", required = true, example = "In_business")
    @NotNull(message = "营业状态不能为null")
    @NotBlank(message = "营业状态不能为空字符串")
    @EnumValueValidator(enumClass = Constants.SiteStatus.class, message = "不是枚举有效值")
    private String operatingStatus;

    @ApiModelProperty(value = "门店图片", required = true, example = "www.baidu.com/111.jpg")
    private String sitePic;

    @ApiModelProperty(value = "团长。团长名规则：4到16位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,16}$", required = true, example = "tuanZhang123")
    @NotNull(message = "团长不能为null")
    @NotBlank(message = "团长不能为空字符串")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "团长名只能包含字母，数字，下划线，减号，且长度在4-16之间")
    private String leader;

    @ApiModelProperty(value = "备注", example = "testtesttest")
    private String comments;

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

    public String getSitePic() {
        return sitePic;
    }

    public void setSitePic(String sitePic) {
        this.sitePic = sitePic;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "SiteDto{" +
                "siteId='" + siteId + '\'' +
                ", name='" + name + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", address='" + address + '\'' +
                ", operatingStatus='" + operatingStatus + '\'' +
                ", sitePic='" + sitePic + '\'' +
                ", leader='" + leader + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
