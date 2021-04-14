package com.myfarm.flashsale.core.modules.user.service.imp;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.id.exception.IdException;
import com.myfarm.flashsale.core.modules.id.service.IdGenerator;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.modelmapper.UserProfileConverter;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileBusinessException;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileNotFoundException;
import com.myfarm.flashsale.core.modules.user.exception.UserProfileParameterException;
import com.myfarm.flashsale.core.modules.user.model.UserProfile;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserProfileMapper;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserRoleMapper;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import com.myfarm.flashsale.core.modules.user.vo.filter.UserProfileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class UserProfileServiceImp implements UserProfileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private UserProfileConverter userProfileConverter;

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
        UserProfile userProfile = null;
        if(!StringUtil.isEmpty(userId)){
            try{
                UUID uuid  = idGenerator.getIDFromString(userId);
                userProfile = userProfileMapper.selectByPrimaryKey(uuid);
            }catch(IdException ex){
                throw new UserProfileBusinessException(ex.getMessage(), ex);
            }catch (Exception ex){
                throw new UserProfileBusinessException(ex.getMessage(), ex);
            }

        }
        if(userProfile  == null){
            String msg = this.messageSource.getMessage("user.notfound.byUserId",new Object[]{userId}, Locale.getDefault());
            throw new UserProfileNotFoundException(msg);
        }
        UserProfileDto userProfileDto = userProfileConverter.domain2dto(userProfile);
        return userProfileDto;
    }

    @Override
    public UserProfileDto getUserProfileByTelPhone(String telPhone) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {
        /*UserProfileExample userProfileExample = new UserProfileExample();
        UserProfileExample.Criteria criteria = userProfileExample.createCriteria();
        if(!StringUtil.isEmpty(telPhone)){
            criteria.andTelphoneEqualTo(telPhone);
        }
        List<UserProfile> user = null;
        try{
            user = userProfileMapper.selectByExample(userProfileExample);
        }catch (Exception ex){
            logger.debug(ex.getMessage(), ex);
            throw new UserProfileBusinessException(ex.getMessage(), ex);
        }
        if(user == null || user.size() == 0){
            String msg = this.messageSource.getMessage("user.notfound.byTelPhone",new Object[]{telPhone}, Locale.getDefault());
        }

        UserProfileDto userProfileDto = userProfileConverter.domain2dto(user.get(0));

         */
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setUserId("47258c37-9687-48cd-85a4-4655e5d497d3");
        userProfileDto.setName("juan");
        userProfileDto.setTelPhone("15319401521");
        userProfileDto.setPsw("NiC$4603");
        userProfileDto.setRoleName(Constants.UserRole.admin.getName());
        return userProfileDto;
    }

    @Override
    public void addUserProfile(UserProfileDto userProfileDto) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {

    }

    @Override
    public void updateUserProfile(UserProfileDto userProfileDto) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {
        return;
    }

    @Override
    public void deleteUserProfileByIds(List<String> userIds) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {

    }

    @Override
    public void setSite(String userId, String siteId) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {

    }

    @Override
    public void getVerificationCode(String telPhone) throws UserProfileParameterException, UserProfileBusinessException, UserProfileNotFoundException {

    }
}
