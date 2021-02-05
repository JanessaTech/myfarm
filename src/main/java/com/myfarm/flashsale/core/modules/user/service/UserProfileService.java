package com.myfarm.flashsale.core.modules.user.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.site.dto.SiteDto;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.filter.UserProfileFilter;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileBusinessException;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileNotFoundException;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileParameterException;

import java.util.List;

public interface UserProfileService {
    PageInfo<UserProfileDto> getUserProfilesByFilter(UserProfileFilter userProfileFilter, int page, int pageSize) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    UserProfileDto getUserProfileById(String userId) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;

    /**
     * Used by login. this method is only used internally
     * @param telPhone
     * @return userId
     * @throws UserProfileParameterException
     * @throws UserProfileBusinessException
     * @throws UserProfileNotFoundException
     */
    UserProfileDto getUserProfileByTelPhone(String telPhone) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void addUserProfile(UserProfileDto userProfileDto) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void deleteUserProfileByIds(List<String> userIds)  throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    SiteDto getSiteByUserId(String userId) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void setSite(String userId, String siteId) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void getVerificationCode(String telPhone) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void userRegister(Integer verificationCode, UserProfileDto userProfileDto) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void updatePassword(String userId, String oldPassword, String newPassword) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void updateTelPhone(String userId, Integer verificationCode, String newPhone) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void updateProfile(String userId, String profile) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;
    void updateName(String userId, String name) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException;

}
