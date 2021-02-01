package com.myfarm.flashsale.core.modules.user.service.imp;

import com.myfarm.flashsale.core.modules.user.dto.UserRoleDto;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleBusinessException;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleNotFoundException;
import com.myfarm.flashsale.core.modules.user.exception.UserRoleParameterException;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserRoleMapper;
import com.myfarm.flashsale.core.modules.user.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImp implements UserRoleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleDto> getAllRoles() throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException {
        return null;
    }

    @Override
    public UserRoleDto getUserRoleById(String roleId) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException {
        return null;
    }

    @Override
    public UserRoleDto addRole(String role) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException {
        return null;
    }

    @Override
    public void deleteRole(String roleId) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException {

    }
}
