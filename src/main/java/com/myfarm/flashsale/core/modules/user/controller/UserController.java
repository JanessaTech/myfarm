package com.myfarm.flashsale.core.modules.user.controller;

import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.filter.UserProfileFilter;
import com.myfarm.flashsale.core.modules.user.exception.*;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import com.myfarm.flashsale.core.modules.user.service.UserRoleService;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Api(value = "账户管理类，主要用来负责角色的增删查及用户对象的增删查改", tags = "User")
@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation(value = "登陆", notes = "返回token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/login", produces = {"application/json"})
    public FarmResponse<UserProfileDto> login(@RequestParam(value = "name", required = true)
                                                          @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "用户名只能包含字母，数字，下划线，减号，且长度在4-16之间")
                                                          @ApiParam(value = "用户名", required = true)
                                                          String name,
                                              @RequestParam(value = "password", required = true)
                                                          @Pattern(regexp = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", message = "最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符")
                                                          @ApiParam(value = "密码", required = true)
                                                          String password) throws UserProfileBusinessException, UserRoleBusinessException {
        return FarmResponse.success();
    }

    @ApiOperation(value = "根据过滤条件返回符合条件的用户",
            notes = "账户/用户列表下的查询操作。共有三处场景触发该方法的调用：<br>1.点击查询按钮  <br>2.对返回的用户列表进行排序操作  <br>3.添加用户后刷信账户/用户列表页面")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(produces = {"application/json"}, consumes = { "application/json"})
    public FarmResponse<UserProfileDto> getUserProfilesByFilter(
                                                              @RequestBody(required = true) @Valid UserProfileFilter userProfileFilter,
                                                              @RequestParam(value = "page", required = true, defaultValue = "0")
                                                                    @Range(min = 0, message = "页码不能小于0")
                                                                    @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                    int page,
                                                              @RequestParam(value = "page_size", required = true, defaultValue = "10")
                                                                    @Range(min = 10, max = 100, message = "页面大小在10-100之间")
                                                                    @ApiParam(value = "页面大小(大小在10-100之间)", required = true, defaultValue = "10", example = "10")
                                                                    int page_size)
            throws UserProfileBusinessException, UserProfileParameterException,
            UserProfileNotFoundException, UserRoleParameterException,
            UserRoleBusinessException, UserRoleNotFoundException {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setUserId("d9a4d5d5-0c9a-4508-952c-091851285a54");
        userProfileDto.setEmployeeId(0);
        userProfileDto.setName("juan");
        userProfileDto.setProfile("www.baidu.com/juan.jpg");
        userProfileDto.setPsw("123456");
        userProfileDto.setRoleId("68f9cca6-642c-4a2c-a37f-ab16124b81df");
        userProfileDto.setRoleName("普通管理员");
        userProfileDto.setTelPhone("15319401521");
        return FarmResponse.success(userProfileDto);
    }
}
