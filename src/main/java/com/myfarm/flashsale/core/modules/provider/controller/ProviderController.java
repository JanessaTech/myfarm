package com.myfarm.flashsale.core.modules.provider.controller;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import com.myfarm.flashsale.core.modules.provider.dto.ProviderDto;
import com.myfarm.flashsale.core.modules.provider.dto.filter.ProviderFilter;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderBusinessException;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderNotFoundException;
import com.myfarm.flashsale.core.modules.provider.exception.ProviderParameterException;
import com.myfarm.flashsale.core.modules.provider.service.ProviderService;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Api(value = "供应商管理。主要负责供应商的增删查改等相关操作", tags = "provider")
@Validated
@RestController
@RequestMapping("/providers")
public class ProviderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ProviderService providerService;


    @ApiOperation(value = "根据过滤条件返回符合条件的供应商", notes = "【供应商/供应商列表】相关查询操作。该页面有三个场景触发该调用：<br>1.点击查询按钮  <br>2.对返回的供应商列表进行排序操作  <br>3.添加供应商成功后对供应商列表进行刷新")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/all", consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<PageInfo<ProviderDto>> getProvidersByFilter(@RequestBody(required = true) @Valid ProviderFilter providerFilter,
                                                                    @RequestParam(value = "page", required = true, defaultValue = "0")
                                                                    @Range(min = 0, message = "页码不能小于0")
                                                                    @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                            int page,
                                                                    @RequestParam(value = "page_size", required = true, defaultValue = "10")
                                                                        @Range(min = 10, max = 50, message = "页面大小在10-50之间")
                                                                        @ApiParam(value = "页面大小(大小在10-50之间)", required = true, defaultValue = "10", example = "10")
                                                                                int page_size) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "返回providerId对应的供应商完整对象", notes = "【供应商/供应商列表】页面下点击修改操作时触发调用")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/{providerId}", produces = {"application/json"})
    public FarmResponse<ProviderDto> getProviderById(@PathVariable(value = "providerId", required = true)
                                                     @NotBlank(message = "providerId不能是空值")
                                                     @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                     @ApiParam(value = "供应商ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                                 String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "添加供应商", notes = "【供应商/供应商列表】页面下的<添加供应商>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"})
    public FarmResponse<Object> addProvider(@RequestBody(required = true) @Valid ProviderDto providerDto) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        /**
         * 此处需要为新ProviderDto生成新的providerId
         */
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "修改供应商信息", notes = "【供应商/供应商列表】页面下的<修改>操作。是否允许修改一个供应商，取决于供应商当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                "<table border=\"1\" align=\"center\"> <tr><th>供应商营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
                                                "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
                                                "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
                                                "</table>" +
                                                "<br>" +
                                                "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<ProviderDto> updateProvider(@RequestBody(required = true) @Valid ProviderDto providerDto) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        /**
         * 这里需做如下参数验证，验证不通过，抛出ProviderParameterException异常：
         *  - providerId非空且为有效值
         */
        //code
        return null;
    }

    @ApiOperation(value = "对providerId代表的供应商做上线操作", notes = "【供应商/供应商列表】页面下的 <上线>操作。 是否允许上线一个供应商，取决于供应商当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                           "<table border=\"1\" align=\"center\"> <tr><th>供应商营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
                                                            "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
                                                            "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
                                                            "</table>" +
                                                            "<br>" +
                                                            "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(value = "/{providerId}/on")
    public FarmResponse<ProviderDto> setProviderOnLine(@PathVariable(value = "providerId", required = true)
                                                           @NotBlank(message = "providerId不能是空值")
                                                           @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                           @ApiParam(value = "供应商ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                                   String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "对providerId代表的供应商做下线操作", notes = "【供应商/供应商列表】页面下的 <下线>操作。 是否允许下线一个供应商，取决于供应商当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                            "<table border=\"1\" align=\"center\"> <tr><th>供应商营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
                                                            "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
                                                            "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
                                                            "</table>" +
                                                            "<br>" +
                                                            "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(value = "/{providerId}/off")
    public FarmResponse<ProviderDto> setProviderOffLine(@PathVariable(value = "providerId", required = true)
                                                            @NotBlank(message = "providerId不能是空值")
                                                            @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                            @ApiParam(value = "供应商ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                                    String providerId) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "删除一个或者多个供应商", notes = "【供应商/供应商列表】页面下的<删除>或者<全删>操作。当删除多个对象时，用','拼接多个providerId作为providerIds的值。 是否允许删除一个供应商，取决于供应商当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                            "<table border=\"1\" align=\"center\"> <tr><th>供应商营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
                                                            "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
                                                            "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
                                                            "</table>" +
                                                            "<br>" +
                                                            "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping
    public FarmResponse<Object> deleteProviderByIds(@RequestParam(value = "providerIds", required = true)
                                                        @NotBlank(message = "providerIds不能是空值")
                                                        @MultipleUUIDValueValidator(message = "参数providerIds含有无效的providerId。providerId必须符合UUID格式。参考：http://www.uuid.online/")
                                                        @ApiParam(value = "待删除的用户的providerId。当多个自提店需要删除，用','拼接providerId", required = true, example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
                                                                String providerIds) throws ProviderParameterException, ProviderBusinessException, ProviderNotFoundException{
        //code
        return FarmResponse.success();
    }
}
