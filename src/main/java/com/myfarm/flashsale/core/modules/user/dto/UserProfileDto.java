package com.myfarm.flashsale.core.modules.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserProfileDto {
    @ApiModelProperty(value = "用户ID", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    private String userId;
    @ApiModelProperty(value = "用户名称", example = "John_9527-test")
    private String name;
    @ApiModelProperty(value = "密码", example = "12345")
    private String psw;
    @ApiModelProperty(value = "电话", example = "15824657732")
    private String telPhone;
    @ApiModelProperty(value = "头像", example = "www.baidu.com/John_9527-test.jpg")
    private String profile;
    @ApiModelProperty(value = "角色id", required = true, example = "68f9cca6-642c-4a2c-a37f-ab16124b81df")
    private String roleId;
    @ApiModelProperty(value = "角色", example = "普通管理员")
    private String roleName;
    @ApiModelProperty(value = "工号", example = "0")
    private int employeeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}

