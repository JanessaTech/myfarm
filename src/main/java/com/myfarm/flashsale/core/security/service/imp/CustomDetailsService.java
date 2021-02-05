package com.myfarm.flashsale.core.security.service.imp;

import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import com.myfarm.flashsale.core.security.domain.CustomUser;
import com.myfarm.flashsale.core.security.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CustomDetailsService implements UserDetailsService {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private MessageSource messageSource;

    @Override
    public UserDetails loadUserByUsername(String telPhone) throws UsernameNotFoundException {
        UserProfileDto userProfileDto = null;
        try{
            userProfileDto = userProfileService.getUserProfileByTelPhone(telPhone);
        }catch (Exception ex){
            throw new UsernameNotFoundException(ex.getMessage(), ex);
        }

        CustomUser customUser = null;
        if(userProfileDto != null){
            UserEntity userEntity = new UserEntity(userProfileDto);
            customUser = new CustomUser(userEntity);
            return customUser;
        }
        String msg = this.messageSource.getMessage("user.notfound.byTelPhone",new Object[]{telPhone}, Locale.getDefault());
        throw new UsernameNotFoundException(msg);
    }
}
