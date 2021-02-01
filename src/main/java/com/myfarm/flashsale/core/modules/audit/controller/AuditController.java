package com.myfarm.flashsale.core.modules.audit.controller;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.audit.dto.AuditDto;
import com.myfarm.flashsale.core.modules.audit.dto.filter.AuditFilter;
import com.myfarm.flashsale.core.modules.audit.exception.AuditBusinessException;
import com.myfarm.flashsale.core.modules.audit.exception.AuditNotFoundException;
import com.myfarm.flashsale.core.modules.audit.exception.AuditParameterException;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
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


@Api(value = "审核。主要负责审核记录的查询及修改操作", tags = "audit")
@Validated
@RestController
@RequestMapping("/audits")
public class AuditController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;

    @ApiOperation(value = "根据过滤条件返回符合条件的审核对象", notes = "【审核/审核记录】页面下的相关查询操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<PageInfo<AuditDto>> getAuditByFilter(@RequestBody(required = true) @Valid AuditFilter auditFilter,
                                                             @RequestParam(value = "page", required = true, defaultValue = "0")
                                                             @Range(min = 0, message = "页码不能小于0")
                                                             @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                     int page,
                                                             @RequestParam(value = "pageSize", required = true, defaultValue = "10")
                                                                 @Range(min = 10, max = 50, message = "页面大小在10-50之间")
                                                                 @ApiParam(value = "页面大小(大小在10-50之间)", required = true, defaultValue = "10", example = "10")
                                                                         int pageSize) throws AuditParameterException, AuditBusinessException, AuditNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "返回auditId对应的完整对象", notes = "【商品/商品列表】页面下点击<审核详情>或者【审核/审核记录】页面下的<修改>操作时触发调用。是否允许查看一个商品的审核记录，取决于商品当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                                                    "<table border=\"1\" align=\"center\"> <tr><th>上架状态</th><th>查看</th><th>修改</th><th>删除</th><th>上架</th><th>下架</th><th>审核</th></tr>" +
                                                                                    "<tr><td>New</td><td>V</td><td>V</td><td>V</td><td>V</td><td>X</td><td>X</td></tr>" +
                                                                                    "<tr><td>On</td><td>V</td><td>X</td><td>X</td><td>X</td><td>V</td><td>V</td></tr>" +
                                                                                    "<tr><td>Off</td><td>V</td><td>V</td><td>V</td><td>V</td><td>X</td><td>X</td></tr>" +
                                                                                    "</table>" +
                                                                                    "<br>" +
                                                                                    "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/{auditId}", produces = {"application/json"})
    public FarmResponse<AuditDto> getAuditById(@PathVariable(value = "auditId", required = true)
                                                   @NotBlank(message = "auditId不能是空值")
                                                   @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                   @ApiParam(value = "审核ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                           String auditId) throws AuditParameterException, AuditBusinessException, AuditNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "修改审核记录", notes = "【商品/商品列表】页面下点击<审核>或者【审核/审核记录】页面下的<修改>操作保存时触发调用。是否允许审核一个商品，取决于商品当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
                                                                                    "<table border=\"1\" align=\"center\"> <tr><th>上架状态</th><th>查看</th><th>修改</th><th>删除</th><th>上架</th><th>下架</th><th>审核</th></tr>" +
                                                                                    "<tr><td>New</td><td>V</td><td>V</td><td>V</td><td>V</td><td>X</td><td>X</td></tr>" +
                                                                                    "<tr><td>On</td><td>V</td><td>X</td><td>X</td><td>X</td><td>V</td><td>V</td></tr>" +
                                                                                    "<tr><td>Off</td><td>V</td><td>V</td><td>V</td><td>V</td><td>X</td><td>X</td></tr>" +
                                                                                    "</table>" +
                                                                                    "<br>" +
                                                                                    "Note: X代表动作不允许，V代表动作允许")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<AuditDto> updateAudit(@RequestBody @Valid AuditDto auditDto) throws AuditParameterException, AuditBusinessException, AuditNotFoundException{
        //code
        return null;
    }

}
