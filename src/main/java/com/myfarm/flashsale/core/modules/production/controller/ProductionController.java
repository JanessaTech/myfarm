package com.myfarm.flashsale.core.modules.production.controller;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import com.myfarm.flashsale.core.modules.production.dto.BandDto;
import com.myfarm.flashsale.core.modules.production.dto.CategoryDto;
import com.myfarm.flashsale.core.modules.production.dto.ProductionDto;
import com.myfarm.flashsale.core.modules.production.dto.filter.ProductionFilter;
import com.myfarm.flashsale.core.modules.production.exception.*;
import com.myfarm.flashsale.core.modules.production.service.BandService;
import com.myfarm.flashsale.core.modules.production.service.CategoryService;
import com.myfarm.flashsale.core.modules.production.service.ProductionService;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
@Api(value = "商品管理。主要负责商品、品牌及分类的增删改查等相关操作", tags = "production")
@Validated
@RestController
@RequestMapping("/productions")
public class ProductionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ProductionService productionService;
    @Autowired
    private BandService bandService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "根据过滤条件返回符合条件的商品", notes = "【商品/商品列表】页面下的相关查询操作。")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/all", consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<PageInfo<ProductionDto>> getProductionsByFilter(@RequestBody(required = true) @Valid ProductionFilter productionFilter,
                                                                        @RequestParam(value = "page", required = true, defaultValue = "0")
                                                                        @Range(min = 0, message = "页码不能小于0")
                                                                        @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                                int page,
                                                                        @RequestParam(value = "pageSize", required = true, defaultValue = "10")
                                                                            @Range(min = 10, max = 50, message = "页面大小在10-50之间")
                                                                            @ApiParam(value = "页面大小(大小在10-50之间)", required = true, defaultValue = "10", example = "10")
                                                                                    int pageSize) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "返回productionId对应的商品完整对象", notes = "【商品/商品列表】页面下点击<查看>或者<修改>操作时触发调用。是否允许查看一个商品，取决于商品当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
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
    @GetMapping(value = "/{productionId}", produces = {"application/json"})
    public FarmResponse<ProductionDto> getProductionById(@PathVariable(value = "productionId", required = true)
                                                             @NotBlank(message = "productionId不能是空值")
                                                             @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                             @ApiParam(value = "商品ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                                String productionId) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "添加商品", notes = "【商品/商品列表】页面下的<添加商品>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<Object> addProduction(@RequestBody(required = true) @Valid ProductionDto productionDto) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException{
        //code
        productionDto.setStatusOnShelf(Constants.ProductionStatus.New.getStatus());
        productionDto.setSalesVolume(0);
        // generate a new productionId for productionDto
        //create a new audit item with the status as Awaiting when insert new production successfully
        return FarmResponse.success();
    }

    @ApiOperation(value = "修改商品", notes = "【商品/商品列表】页面下的<修改>操作。是否允许修改一个商品，取决于商品当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
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
    public FarmResponse<ProductionDto> updateProduction(@RequestBody(required = true) @Valid ProductionDto productionDto) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException{
        //code
        // check if productionId in productionDto exits, if not, throw ProductionParameterException
        return null;
    }


    @ApiOperation(value = "设置productionId对应的商品的上架状态", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(value = "/{productionId}/status", produces = {"application/json"})
    public FarmResponse<ProductionDto> setProductionStatus(@PathVariable(value = "productionId", required = true)
                                                               @NotBlank(message = "productionId不能是空值")
                                                               @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                               @ApiParam(value = "商品ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                                String productionId,
                                                           @RequestParam(value = "status", required = true)
                                                           @NotNull(message = "status不能是null值")
                                                           @NotEmpty(message = "status不能是空值")
                                                           @EnumValueValidator(enumClass = Constants.ProductionStatus.class, message = "不是枚举有效值")
                                                           @ApiParam(value = "上架状态。有效枚举值：New, On, Off", required = true, example = "New")
                                                                   String status) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException{
        //code
        return null;
    }


    @ApiOperation(value = "删除一个或者多个商品", notes = "【商品/商品列表】页面下的<删除>或者<全删>操作。当删除多个对象时，用','拼接多个productionId作为productionIds的值。是否允许删除一个商品，取决于商品当前的状态。下面的表格说明不同状态下可以允许的操作：<br>" +
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
    @DeleteMapping(value = "/{productionIds}")
    public FarmResponse<Object> deleteProductionByIds(@PathVariable(value = "productionIds", required = true)
                                                          @NotBlank(message = "productionIds不能是空值")
                                                          @MultipleUUIDValueValidator(message = "参数productionIds含有无效的productionId。productionId必须符合UUID格式。参考：http://www.uuid.online/")
                                                          @ApiParam(value = "待删除的商品的productionId。当多个商品需要删除，用','拼接productionId", required = true, example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
                                                            String productionIds) throws ProductionParameterException, ProductionBusinessException, ProductionNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "返回系统里的所有品牌对象", notes = "【商品/品牌管理】页面下的 <品牌列表>。返回结果以<品牌ID>列进行升序排序")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/bands", produces = {"application/json"})
    public FarmResponse<List<BandDto>> getAllBands() throws BandParameterException, BandBusinessException, BandNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "添加品牌", notes = "【商品/品牌管理】页面下的<添加>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/bands", produces = {"application/json"})
    public FarmResponse<BandDto> addBand(@RequestParam(value = "band", required = true)
                                             @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "品牌只能包含字母，数字，下划线，减号，且长度在4-30之间")
                                             @ApiParam(value = "品牌。只能包含字母，数字，下划线，减号，且长度在4-30之间。符合的正则表达式：^[a-zA-Z0-9_-]{4,16}$", required = true, example = "band123")
                                                     String band) throws BandParameterException, BandBusinessException, BandNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "删除品牌", notes = "【商品/品牌管理】页面下的<删除>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping(value = "/bands/{bandId}")
    public FarmResponse<Object> deleteBandById(@PathVariable(value = "bandId", required = true)
                                                   @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                   @ApiParam(value = "品牌ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                           String bandId) throws BandParameterException, BandBusinessException, BandNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "返回系统里的所有分类对象", notes = "【商品/商品分类】页面下的 <分类列表>。返回结果以<分类ID>列进行升序排序")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/categories", produces = {"application/json"})
    public FarmResponse<List<CategoryDto>> getAllCategories() throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "添加分类", notes = "【商品/商品分类】页面下的<添加>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/categories", produces = {"application/json"})
    public FarmResponse<CategoryDto> addCategory(@RequestParam(value = "category", required = true)
                                                 @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "分类只能包含字母，数字，下划线，减号，且长度在4-30之间")
                                                 @ApiParam(value = "分类。4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", required = true, example = "category1234")
                                                             String category) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "删除分类", notes = "【商品/商品分类】页面下的<删除>操作")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping(value = "/categories/{categoryId}")
    public FarmResponse<Object> deleteCategoryById(@PathVariable(value = "categoryId", required = true)
                                                       @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                       @ApiParam(value = "分类ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "04749fa6-791a-4ca9-ac7f-900f6d12f9a3")
                                                               String categoryId) throws CategoryParameterException, CategoryBusinessException, CategoryNotFoundException{
        //code
        return FarmResponse.success();
    }
}
