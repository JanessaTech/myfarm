package com.myfarm.flashsale.core.modules.user.controller;

import com.myfarm.flashsale.core.modules.user.model.UserProfile;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tuoke-web/api/auth2/users")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<UserProfile> userProfiles = this.userProfileService.getAll();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }
}
