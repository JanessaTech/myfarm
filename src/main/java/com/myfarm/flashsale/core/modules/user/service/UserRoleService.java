package com.myfarm.flashsale.core.modules.user.service;

import com.myfarm.flashsale.core.modules.user.dto.UserRoleDto;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleBusinessException;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleNotFoundException;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleParameterException;

import java.util.List;

public interface UserRoleService{
    /**
     * return all user roles
     * by default, sort result by role_id in ascending order
     * @return
     */
    List<UserRoleDto> getAllRoles() throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException;
    UserRoleDto getUserRoleById(String roleId) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException;
    UserRoleDto addRole(String role) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException;
    void deleteRole(String roleId) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException;
}
