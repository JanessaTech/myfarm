package com.myfarm.flashsale.core.modules.user.dto.modelmapper;

import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.model.UserProfile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserProfileConverter {
    //UserProfileConverter INSTANCE = Mappers.getMapper(UserProfileConverter.class);
    UserProfileDto domain2dto(UserProfile userProfile);
    List<UserProfileDto> domain2dto(List<UserProfile> userProfileList);
    default String map(Object value){
        return value.toString();
    }

}
