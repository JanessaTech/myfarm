package com.myfarm.flashsale.core.modules.user.service;

import com.myfarm.flashsale.core.modules.user.dto.UserRoleDto;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleBusinessException;

import java.util.List;

public interface UserRoleService {
    /**
     * return all user roles
     * by default, sort result by role_id in ascending order
     * @return
     */
    List<UserRoleDto> getAllRoles();
    UserRoleDto getUserRoleById(String roleId) throws UserRoleBusinessException;
    void addRole(String role) throws UserRoleBusinessException;
    void deleteRole(String roleId) throws UserRoleBusinessException;
}
