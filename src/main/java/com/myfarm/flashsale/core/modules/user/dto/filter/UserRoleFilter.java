package com.myfarm.flashsale.core.modules.user.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;

public class UserRoleFilter {
    private String roleId = "";
    private String roleName = "";
    private String orderBy = "role_id";
    private String order = Constants.Order.ASC.getCode();

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

    @Override
    public String toString() {
        return "UserRoleFilter{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
