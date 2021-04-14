package com.myfarm.flashsale.core.modules.site.controller;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import com.myfarm.flashsale.core.modules.site.exception.SiteBusinessException;
import com.myfarm.flashsale.core.modules.site.exception.SiteNotFoundException;
import com.myfarm.flashsale.core.modules.site.exception.SiteParameterException;
import com.myfarm.flashsale.core.modules.site.service.SiteService;
import com.myfarm.flashsale.core.modules.site.vo.SiteAddVo;
import com.myfarm.flashsale.core.modules.site.vo.SiteShowVo;
import com.myfarm.flashsale.core.modules.site.vo.SiteUpdateVo;
import com.myfarm.flashsale.core.modules.site.vo.filter.SiteFilter;
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
import javax.validation.constraints.NotEmpty;

@Api(value = "自提店管理。主要负责自提店的增删改查等相关操作", tags = "site")
@Validated
@RestController
@RequestMapping("/sites")
public class SiteController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SiteService siteService;

    @ApiOperation(value = "根据过滤条件返回符合条件的自提店", notes = "【自提店/自提店列表】相关查询操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/all", consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<PageInfo<SiteShowVo>> getSitesByFilter(@RequestBody(required = true) @Valid SiteFilter siteFilter,
                                                               @RequestParam(value = "page", required = true, defaultValue = "0")
                                                            @Range(min = 0, message = "页码不能小于0")
                                                            @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                    int page,
                                                               @RequestParam(value = "page_size", required = true, defaultValue = "10")
                                                                @Range(min = 10, max = 50, message = "页面大小在10-50之间")
                                                                @ApiParam(value = "页面大小(大小在10-50之间)", required = true, defaultValue = "10", example = "10")
                                                                        int page_size) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "返回siteId对应的自提店完整对象", notes = "【自提店/自提店列表】页面下点击修改操作时触发调用")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/{siteId}", produces = {"application/json"})
    public FarmResponse<SiteShowVo> getSiteById(@PathVariable(value = "siteId", required = true)
                                            @NotBlank(message = "siteId不能是空值")
                                            @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                            @ApiParam(value = "自提店ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                        String siteId) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "添加自提店", notes = "【自提店/自提店列表】页面下的<添加自提店>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"})
    public FarmResponse<Object> addSite(@RequestBody(required = true) @Valid SiteAddVo siteAddVo) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        /**
         * 此处需要为新SiteDto生成新的siteId
         */
        //code
        return FarmResponse.success();
    }


    @ApiOperation(value = "修改自提店信息", notes = "【自提店/自提店列表】页面下的 <修改>操作。是否允许修改一个自提店，取决于自提店当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                    "<table border=\"1\" align=\"center\"> <tr><th>自提店营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
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
    public FarmResponse<Object> updateSite(@RequestBody(required = true) @Valid SiteUpdateVo siteUpdateVo) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        /**
         * 这里需做如下参数验证，验证不通过，抛出SiteParameterException异常：
         *  - siteId非空且为有效值
         */
        //code
        return null;
    }


    @ApiOperation(value = "对siteId代表的自提店进行上线操作", notes = "【自提店/自提店列表】页面下的 <上线>操作。是否允许上线一个自提店，取决于自提店当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                "<table border=\"1\" align=\"center\"> <tr><th>自提店营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
                                                "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
                                                "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
                                                "</table>" +
                                                "<br>" +
                                                "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(value = "/{siteId}/on", produces = {"application/json"})
    public FarmResponse<Object> setSiteOn(@PathVariable(value = "siteId", required = true)
                                               @NotBlank(message = "siteId不能是null值")
                                               @NotEmpty(message = "siteId不能是空值")
                                               @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                               @ApiParam(value = "自提店ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                       String siteId) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        //code
        String status = Constants.SiteStatus.In_business.getStatus();
        return null;
    }

    @ApiOperation(value = "对siteId代表的自提店进行下线操作", notes = "【自提店/自提店列表】页面下的 <下线>操作。是否允许下线一个自提店，取决于自提店当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                           "<table border=\"1\" align=\"center\"> <tr><th>自提店营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
                                                            "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
                                                            "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
                                                            "</table>" +
                                                            "<br>" +
                                                            "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(value = "/{siteId}/off", produces = {"application/json"})
    public FarmResponse<Object> setSiteOff(@PathVariable(value = "siteId", required = true)
                                               @NotBlank(message = "siteId不能是null值")
                                               @NotEmpty(message = "siteId不能是空值")
                                               @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                               @ApiParam(value = "自提店ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                       String siteId) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        //code
        String status = Constants.SiteStatus.Out_business.getStatus();
        return null;
    }

    @ApiOperation(value = "删除一个或者多个自提店", notes = "【自提店/自提店列表】页面下的<删除>或者<全删>操作。当删除多个对象时，用','拼接多个siteId作为siteIds的值  <br>是否允许删除一个自提店，取决于自提店当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
            "<table border=\"1\" align=\"center\"> <tr><th>自提店营业状态</th><th>修改</th><th>删除</th><th>上线</th><th>下线</th></tr>" +
            "<tr><td>In_business</td><td>X</td><td>X</td><td>X</td><td>V</td></tr>" +
            "<tr><td>Out_business</td><td>V</td><td>V</td><td>V</td><td>X</td></tr>" +
            "</table>"+
            "<br>" +
            "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping(value = "/{siteIds}")
    public FarmResponse<Object> deleteSiteByIds(@PathVariable(value = "siteIds", required = true)
                                                @NotBlank(message = "siteIds不能是null值")
                                                @NotEmpty(message = "siteIds不能是空值")
                                                @MultipleUUIDValueValidator(message = "参数siteIds含有无效的siteId。userId必须符合UUID格式。参考：http://www.uuid.online/")
                                                @ApiParam(value = "待删除的自提店的siteId。当多个自提店需要删除，用','拼接siteId", required = true, example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
                                                            String siteIds) throws SiteParameterException, SiteBusinessException, SiteNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "返回userId当前设置的自提店完整对象", notes = "【前端：订单确认】页面下自提店信息展示")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/{userId}/site", produces = {"application/json"})
    public FarmResponse<SiteShowVo> getSiteByUserId(@PathVariable(value = "userId", required = true)
                                                    @NotBlank(message = "userId不能是空值")
                                                    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                    @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3") String userId) throws SiteParameterException, SiteBusinessException, SiteNotFoundException {
        //code
        return null;
    }

}
