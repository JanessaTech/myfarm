package com.myfarm.flashsale.core.modules.user.controller;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import com.myfarm.flashsale.core.modules.site.dto.SiteDto;
import com.myfarm.flashsale.core.modules.site.exception.SiteBusinessException;
import com.myfarm.flashsale.core.modules.site.exception.SiteNotFoundException;
import com.myfarm.flashsale.core.modules.site.exception.SiteParameterException;
import com.myfarm.flashsale.core.modules.user.dto.LoginInfo;
import com.myfarm.flashsale.core.modules.user.dto.UserProfileDto;
import com.myfarm.flashsale.core.modules.user.dto.UserRoleDto;
import com.myfarm.flashsale.core.modules.user.dto.filter.UserProfileFilter;
import com.myfarm.flashsale.core.modules.user.exception.*;
import com.myfarm.flashsale.core.modules.user.service.UserProfileService;
import com.myfarm.flashsale.core.modules.user.service.UserRoleService;
import com.myfarm.flashsale.core.security.domain.Token;
import com.myfarm.flashsale.core.security.exception.TokenException;
import com.myfarm.flashsale.core.security.service.TokenManager;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Api(value = "账户管理。主要用来负责角色的增删查及用户对象的增删查改", tags = "user")
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

    @Autowired
    @Qualifier("auth2TokenManager")
    private TokenManager auth2TokenManager;

    @ApiOperation(value = "登陆", notes = "返回token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/login", produces = {"application/json"})
    public FarmResponse<LoginInfo> login(@RequestParam(value = "telPhone", required = true)
                                         @NotNull(message = "telPhone不能为null")
                                         @NotEmpty(message = "telPhone不能为空值")
                                         @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确")
                                         @ApiParam(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", required = true, example = "15319401521")
                                                 String telPhone,
                                         @RequestParam(value = "password", required = true)
                                        @Pattern(regexp = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", message = "最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符")
                                        @ApiParam(value = "密码", required = true) String password) throws UserProfileBusinessException, UserRoleBusinessException, LoginAuth2Exception, UserProfileNotFoundException, UserProfileParameterException {
        Token token = null;
        try {
            token  = auth2TokenManager.createToken(telPhone, password);
        } catch (TokenException e) {
            e.printStackTrace();
            throw new LoginAuth2Exception(e.getMessage(),e);
        }

        UserProfileDto userProfileDto = userProfileService.getUserProfileByTelPhone(telPhone);
        LoginInfo loginInfo = new LoginInfo(token, userProfileDto.getUserId());

        return FarmResponse.success(loginInfo);
    }

    @ApiOperation(value = "登出", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/logout")
    public FarmResponse<Object> logout() throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }



    @ApiOperation(value = "根据过滤条件返回符合条件的用户",
            notes = "【账户/用户列表】页面下的相关查询操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/all", produces = {"application/json"}, consumes = { "application/json"})
    public FarmResponse<PageInfo<UserProfileDto>> getUserProfilesByFilter(
                                                              @RequestBody(required = true) @Valid UserProfileFilter userProfileFilter,
                                                              @RequestParam(value = "page", required = true, defaultValue = "0")
                                                                    @Range(min = 0, message = "页码不能小于0")
                                                                    @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                    int page,
                                                              @RequestParam(value = "page_size", required = true, defaultValue = "10")
                                                                    @Range(min = 10, max = 50, message = "页面大小在10-50之间")
                                                                    @ApiParam(value = "页面大小(大小在10-50之间)", required = true, defaultValue = "10", example = "10")
                                                                    int page_size)
            throws UserProfileBusinessException, UserProfileParameterException,
            UserProfileNotFoundException{
        return null;
    }

    @ApiOperation(value = "返回userId对应的用户完整对象", notes = "【账户/角色管理】页面下点击修改操作时触发调用")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/{userId}", produces = {"application/json"})
    public FarmResponse<UserProfileDto> getUserProfileById(@PathVariable(value = "userId", required = true)
                                                        @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                        @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "92dde1a3-a1db-4ab1-921d-f5bcd9ab0ce6")
                                                                    String userId) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{

      return null;
    }


    @ApiOperation(value = "添加用户", notes = "【账户/角色管理】页面下的<添加用户>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"})
    public FarmResponse<Object> addUserProfile(@RequestBody(required = true) @Valid UserProfileDto userProfileDto) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        /**
         * 这里需做如下参数验证，验证不通过，抛出UserRoleParameterException异常：
         *  - 当角色为非普通用户时，工号必须有有效值
         */
        /**
         * 此处需要为新用户生成新的userId
         */
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "修改用户信息", notes = "【账户/角色管理】页面下的 <修改>操作。修改成功后，返回修改后的用户对象")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "", response = FarmResponse.class)
    })
    @PutMapping(consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<UserProfileDto> updateUserProfile(@RequestBody(required = true) @Valid UserProfileDto userProfileDto) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
     /**
     * 这里需做如下参数验证，验证不通过，抛出UserRoleParameterException异常：
     *  - 当角色为非普通用户时，工号必须有有效值
     *  - userId非空且为有效值
     */
        /**
         * 注意：更新数据时，如果用户为普通用户，工号强制置为空值
         */
        //code
        return null;
    }

    @ApiOperation(value = "删除一个或者多个用户", notes = "【账户/角色管理】页面下的<删除>或者<全删>操作。当删除多个对象时，用','拼接多个userId作为userIds的值")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping(value = "/{userIds}")
    public FarmResponse<Object> deleteUserProfileById(@PathVariable(value = "userIds", required = true)
                                                      @NotBlank(message = "userIds不能是空值")
                                                      @MultipleUUIDValueValidator(message = "参数userIds含有无效的userId。userId必须符合UUID格式。参考：http://www.uuid.online/")
                                                      @ApiParam(value = "待删除的用户的userId。当多个用户需要删除，用','拼接userId", required = true, example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
                                                                  String userIds)  throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }


    @ApiOperation(value = "返回userId当前设置的自提店完整对象", notes = "【前端：订单确认】页面下自提店信息展示")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/{userId}/site", produces = {"application/json"})
    public FarmResponse<SiteDto> getSiteByUserId(@PathVariable(value = "userId", required = true)
                                                 @NotBlank(message = "userId不能是空值")
                                                 @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                 @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                 String userId) throws SiteParameterException, SiteBusinessException, SiteNotFoundException {
        //code
        return null;
    }

    @ApiOperation(value = "门店设置", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/{userId}/site")
    public FarmResponse<Object> setSite(@PathVariable(value = "userId", required = true)
                                            @NotBlank(message = "userId不能是空值")
                                            @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                            @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                    String userId,
                                        @RequestParam(value = "siteId", required = true)
                                        @NotBlank(message = "siteId不能是空值")
                                        @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                        @ApiParam(value = "门店ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                String siteId) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "获取验证码", notes = "验证码以短信形式发送到telPhone对应的手机")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/verificationCode")
    public FarmResponse<Object> getVerificationCode(@RequestParam(value = "telPhone", required = true)
                                                     @NotNull(message = "telPhone不能为null")
                                                     @NotEmpty(message = "telPhone不能为空值")
                                                     @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确")
                                                     @ApiParam(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", required = true, example = "15824657732")
                                                     String telPhone) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        return FarmResponse.success();
    }

    @ApiOperation(value = "用户注册", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/register", consumes = {"application/json"})
    public FarmResponse<Object> userRegister(@RequestParam(value = "verificationCode", required = true)
                                             @NotNull(message = "verificationCode不能为null")
                                             Integer verificationCode,
                                             @ApiParam(value = "手机验证码", required = true, example = "1234")
                                             @RequestBody(required = true) @Valid UserProfileDto userProfileDto) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }



    @ApiOperation(value = "修改密码", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/{userId}/password")
    public FarmResponse<Object> updatePassword(@PathVariable(value = "userId", required = true)
                                                   @NotBlank(message = "userId不能是空值")
                                                   @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                   @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                           String userId,
                                               @RequestParam(value = "oldPassword", required = true)
                                               @NotNull(message = "oldPassword不能为null")
                                               @NotEmpty(message = "oldPassword不能为空值")
                                               @Pattern(regexp = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", message = "旧密码含有无效字符")
                                               @ApiParam(value = "密码。密码规则：最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符。正则表达式：^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", required = true, example = "NiC$4603")
                                               String oldPassword,
                                               @RequestParam(value = "newPassword", required = true)
                                                   @NotNull(message = "newPassword不能为null")
                                                   @NotEmpty(message = "newPassword不能为空值")
                                                   @Pattern(regexp = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", message = "新密码含有无效字符")
                                                   @ApiParam(value = "密码。密码规则：最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符。正则表达式：^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", required = true, example = "NiC$4603")
                                                           String newPassword) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "更新电话", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/{userId}/phone")
    public FarmResponse<Object> updateTelPhone(@PathVariable(value = "userId", required = true)
                                                   @NotBlank(message = "userId不能是空值")
                                                   @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                   @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                           String userId,
                                               @RequestParam(value = "verificationCode", required = true)
                                               @NotNull(message = "verificationCode不能为null")
                                               Integer verificationCode,
                                               @RequestParam(value = "newPhone", required = true)
                                               @NotNull(message = "newPhone不能为null")
                                               @NotEmpty(message = "newPhone不能为空值")
                                               @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "电话号码格式不正确")
                                               @ApiParam(value = "电话。支持电信、移动、联通等运营商，详情见：https://blog.csdn.net/gxzhaha/article/details/108115777。正则表达式：^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", required = true, example = "15824657732")
                                               String newPhone) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "更新头像", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/{userId}/profile")
    public FarmResponse<Object> updateProfile(@PathVariable(value = "userId", required = true)
                                                  @NotBlank(message = "userId不能是空值")
                                                  @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                  @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                          String userId,
                                              @RequestParam(value = "profile", required = true)
                                              @NotNull(message = "profile不能为null")
                                              @NotEmpty(message = "profile不能为空值")
                                              String profile) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "更新昵称", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = FarmResponse.class),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/{userId}/name")
    public FarmResponse<Object> updateName(@PathVariable(value = "userId", required = true)
                                              @NotBlank(message = "userId不能是空值")
                                              @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                              @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                      String userId,
                                              @RequestParam(value = "name", required = true)
                                              @NotNull(message = "name不能为null")
                                              @NotEmpty(message = "name不能为空值")
                                              @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "用户名只能包含字母，数字，下划线，减号，且长度在4-16之间")
                                                      @ApiParam(value = "用户名称。用户名规则：4到16位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,16}$", required = true, example = "juan")
                                                      String name) throws UserProfileParameterException,UserProfileBusinessException, UserProfileNotFoundException{
        //code
        return FarmResponse.success();
    }




    @ApiOperation(value = "返回系统里所有的角色", notes = "【账户/角色管理】页面下的 <角色列表>。返回结果以<角色ID>列进行升序排序")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/roles", produces = {"application/json"})
    public FarmResponse<List<UserRoleDto>> getAllRoles() throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "添加角色", notes = "【账户/角色管理】页面下的<添加角色>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/roles", produces = {"application/json"})
    public FarmResponse<UserRoleDto> addRole(@RequestParam(value = "role", required = true)
                                        @Pattern(regexp = "^[a-zA-Z]{3,10}$", message = "角色名为3-10位大小写字母组成")
                                        @ApiParam(value = "角色。输入的内容符合正则表达式：^[a-zA-Z]{3,10}$", required = true, example = "admin")
                                        String role) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException{
       //code
        return null;
    }

    @ApiOperation(value = "删除角色", notes = "【账户/角色管理】页面下的<角色列表>的删除操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping(value = "/roles/{roleId}", produces = {"application/json"})
    public FarmResponse<Object> deleteRole(@PathVariable(value = "roleId", required = true)
                                        @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                        @ApiParam(value = "角色ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                String roleId) throws UserRoleParameterException, UserRoleBusinessException, UserRoleNotFoundException{
       //code
        return FarmResponse.success();
    }
}
