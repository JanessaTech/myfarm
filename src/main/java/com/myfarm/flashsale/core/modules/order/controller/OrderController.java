package com.myfarm.flashsale.core.modules.order.controller;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import com.myfarm.flashsale.core.modules.order.dto.OrderDetailDto;
import com.myfarm.flashsale.core.modules.order.dto.OrderDto;
import com.myfarm.flashsale.core.modules.order.dto.filter.OrderDetailFilter;
import com.myfarm.flashsale.core.modules.order.dto.filter.OrderFilter;
import com.myfarm.flashsale.core.modules.order.exception.OrderBusinessException;
import com.myfarm.flashsale.core.modules.order.exception.OrderNotFoundException;
import com.myfarm.flashsale.core.modules.order.exception.OrderParameterException;
import com.myfarm.flashsale.core.modules.order.repository.mappers.OrderMapper;
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
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(value = "订单相关操作", tags = "order")
@Validated
@RestController
@RequestMapping("/orders")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private OrderMapper orderMapper;


    @ApiOperation(value = "创建订单", notes = "创建订单的具体包括：<br>1.查询cartItemIds对应的cart信息  <br>2. 创建订单 <br>3.根据#1创建order_detail信息<br>4.删除cartItemIds对应的购物车信息   <br>5.返回新创建的订单信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"})
    public FarmResponse<String> createOrder(@RequestParam(value = "cartItemIds", required = true)
                                            @NotNull(message = "cartItemIds不能为null")
                                            @NotBlank(message = "cartItemIds不能为空值")
                                            @MultipleUUIDValueValidator(message = "参数cartItemIds含有无效的cartItemId。cartItemId必须符合UUID格式。参考：http://www.uuid.online/")
                                            @ApiParam(value = "待创建订单的购物车的条目(用cartItemId表示)。当有多个条目用来创建订单， 用','拼接cartItemId", required = true, example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
                                            String cartItemIds,
                                            @RequestBody(required = true) @Valid OrderDto orderDto) throws OrderParameterException, OrderBusinessException, OrderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "根据过滤规则返回相关的订单信息", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<PageInfo<List<OrderDto>>> getOrdersByFilter(@RequestBody(required = true) @Valid OrderFilter orderFilter,
                                                                    @RequestParam(value = "page", required = true, defaultValue = "0")
                                                                    @Range(min = 0, message = "页码不能小于0")
                                                                    @ApiParam(value = "页码(不能小于0)", required = true, defaultValue = "0", example = "0")
                                                                            int page,
                                                                    @RequestParam(value = "pageSize", required = true, defaultValue = "10")
                                                                        @Range(min = 10, max = 50, message = "页面大小在10-50之间")
                                                                        @ApiParam(value = "页面大小(大小在10-50之间)", required = true, defaultValue = "10", example = "10")
                                                                                int pageSize) throws OrderParameterException, OrderBusinessException, OrderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "根据过滤规则返回相关的订单详情信息", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @GetMapping(value = "/detail", consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<PageInfo<List<OrderDetailDto>>> getOrderDetails(@RequestBody(required = true)
                                                                        @Valid OrderDetailFilter orderDetailFilter) throws OrderParameterException, OrderBusinessException, OrderNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "删除orderId对应的订单及其关联数据", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping
    public FarmResponse<Object> deleteOrderById(@RequestParam(value = "orderId", required = true)
                                                @NotNull(message = "orderId不能为null")
                                                @NotBlank(message = "orderId不能对空值")
                                                @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                @ApiParam(value = "订单ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "92dde1a3-a1db-4ab1-921d-f5bcd9ab0ce6")
                                                            String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "更新订单数据", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PutMapping(consumes = {"application/json"})
    public FarmResponse<Object> updateOrder(@RequestBody(required = true) @Valid OrderDto orderDto) throws OrderParameterException, OrderBusinessException, OrderNotFoundException{
        //code
        return FarmResponse.success();
    }
}
