package com.myfarm.flashsale.core.modules.user.service.imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.filter.UserProfileFilter;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileBusinessException;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileNotFoundException;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileParameterException;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserProfileMapper;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserRoleMapper;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserProfileServiceImp implements UserProfileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private UserProfileMapper userProfileMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public PageInfo<UserProfileDto> getUserProfilesByFilter(UserProfileFilter userProfileFilter, int page, int pageSize) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {
        return null;
    }

    @Override
    public UserProfileDto getUserProfileById(String userId) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {
        return null;
    }

    @Override
    public void addUserProfile(UserProfileDto userProfileDto) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {

    }

    @Override
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {
        return null;
    }

    @Override
    public void deleteUserProfileByIds(List<String> userIds) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {

    }
}
