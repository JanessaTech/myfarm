package com.myfarm.flashsale.core.modules.user.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.filter.UserProfileFilter;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileBusinessException;

import java.util.List;

public interface UserProfileService {
    PageInfo<UserProfileDto> getUserProfilesByFilter(UserProfileFilter userProfileFilter, int page, int pageSize) throws UserProfileBusinessException;
    UserProfileDto getUserProfileById(String userId) throws UserProfileBusinessException;
    void addUserProfile(UserProfileDto userProfileDto) throws UserProfileBusinessException;
    UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws UserProfileBusinessException;
    void deleteUserProfileById(String userId) throws UserProfileBusinessException;
    void deleteUserProfileByIds(List<String> userIds) throws UserProfileBusinessException;
    //void setUserProfileSite(String siteId, String userId) throws UserProfileException;
}
