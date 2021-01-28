package com.myfarm.flashsale.core.modules.user.dto;

import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

@ApiModel
public class UserRoleDto {
    @ApiModelProperty(value = "角色ID. 符合UUID格式。参考：http://www.uuid.online", example = "17802761-c475-46c4-98dc-210b1994c7cd")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String roleId;

    @ApiModelProperty(value = "角色。角色规则：3-10位大小写字母组成符合。正则表达式：^[a-zA-Z]{3,10}$", example = "admin")
    @Pattern(regexp = "^[a-zA-Z]{3,10}$", message = "角色名为3-10位大小写字母组成")
    private String roleName;

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
}
