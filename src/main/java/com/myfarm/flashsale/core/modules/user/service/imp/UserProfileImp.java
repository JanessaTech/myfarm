package com.myfarm.flashsale.core.modules.user.service.imp;

import com.myfarm.flashsale.core.modules.user.model.UserProfile;
import com.myfarm.flashsale.core.modules.user.model.UserProfileExample;
import com.myfarm.flashsale.core.modules.user.repository.mappers.UserProfileMapper;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileImp implements UserProfileService {
    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public List<UserProfile> getAll() {
        UserProfileExample userProfileExample = new UserProfileExample();
        UserProfileExample.Criteria criteria = userProfileExample.createCriteria();
        List<UserProfile> userProfiles = this.userProfileMapper.selectByExample(userProfileExample);
        return userProfiles;
    }
}
