package com.myfarm.flashsale.core.security.domain;

import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserEntity {
    private String username;
    private String password;
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

    public UserEntity(UserProfileDto userProfileDto){
        this.username = userProfileDto.getTelPhone();// here the username is actually the telPhone
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.password = "{bcrypt}"+bCryptPasswordEncoder.encode(userProfileDto.getPsw());
        List<GrantedAuthority> list = AuthorityUtils.createAuthorityList(userProfileDto.getRoleName());
        this.grantedAuthoritiesList = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GrantedAuthority> getGrantedAuthoritiesList() {
        return grantedAuthoritiesList;
    }

    public void setGrantedAuthoritiesList(Collection<GrantedAuthority> grantedAuthoritiesList) {
        this.grantedAuthoritiesList = grantedAuthoritiesList;
    }
}
