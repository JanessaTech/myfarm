package com.myfarm.flashsale.core.modules.user.service.imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.filter.UserProfileFilter;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileBusinessException;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserProfileMapper;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private UserProfileMapper userProfileMapper;

    @Override
    public PageInfo<UserProfileDto> getUserProfilesByFilter(UserProfileFilter userProfileFilter, int page, int pageSize) throws UserProfileBusinessException {
        return null;
    }

    @Override
    public UserProfileDto getUserProfileById(String userId) throws UserProfileBusinessException {
        return null;
    }

    @Override
    public void addUserProfile(UserProfileDto userProfileDto) throws UserProfileBusinessException {

    }

    @Override
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws UserProfileBusinessException {
        return null;
    }

    @Override
    public void deleteUserProfileById(String userId) throws UserProfileBusinessException {

    }

    @Override
    public void deleteUserProfileByIds(List<String> userIds) throws UserProfileBusinessException {

    }
}
