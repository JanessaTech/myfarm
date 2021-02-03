package com.myfarm.flashsale.core.modules.cart.controller;

import com.myfarm.flashsale.core.modules.cart.dto.CartDto;
import com.myfarm.flashsale.core.modules.cart.dto.filter.CartFilter;
import com.myfarm.flashsale.core.modules.cart.exception.CartBusinessException;
import com.myfarm.flashsale.core.modules.cart.exception.CartNotFoundException;
import com.myfarm.flashsale.core.modules.cart.exception.CartParameterException;
import com.myfarm.flashsale.core.modules.cart.service.CartService;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import com.myfarm.flashsale.core.modules.common.validation.MultipleUUIDValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.*;
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

@Api(value = "购物车相关操作", tags = "cart")
@Validated
@RestController
@RequestMapping("/cart")
public class CartController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CartService cartService;

    @ApiOperation(value = "根据过滤条件返回相应的购物车的条目", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(value = "/all", consumes = {"application/json"}, produces = {"application/json"})
    public FarmResponse<List<CartDto>> getCartContent(@RequestBody(required = true) @Valid CartFilter cartFilter) throws CartParameterException, CartBusinessException, CartNotFoundException{
        //code
        return null;
    }

    @ApiOperation(value = "用户添加购物车行为", notes = "参数cartDtos代表购物车距上次添加行为购物车的改变增量。CartDto对象如果没有cartItemId属性，增表示首次新加入购物车的商品，如果有cartItemId属性，增表示该商品的数量发生了改变")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @PostMapping(consumes = {"application/json"})
    public FarmResponse<Object> updateCartContent(@RequestParam(required = true)
                                                      @NotNull(message = "userId不能为null")
                                                      @NotBlank(message = "userId不能为空值")
                                                      @UUIDValueValidator(isAllowEmpty = false, message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                      @ApiParam(value = "用户ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
                                                      String userId,
                                                  @RequestBody(required = true) @Valid List<CartDto> cartDtos) throws CartParameterException, CartBusinessException, CartNotFoundException{
        //code
        return FarmResponse.success();
    }

    @ApiOperation(value = "删除cartItemIds对应的在购物车的条目", notes = "如果cartItemIds没有传值，则清空购物车")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "参数校验异常", response = FarmResponse.class)
    })
    @DeleteMapping
    public FarmResponse<Object> deleteCartContentById(@RequestParam(value = "cartItemIds", required = false)
                                                      @MultipleUUIDValueValidator(isAllowEmpty = true, message = "不是有效的UUID格式。参考：http://www.uuid.online/")
                                                      @ApiParam(value = "待删除的购物车的条目。有多个条目需要删除时，把各条目的cartItemId用','连接起来。cartItemId必须符合UUID格式", example = "3e1e3805-8ed9-496f-82ae-e07e8f795954,fa8c2845-4134-443a-a842-f47441167748")
                                                      String cartItemIds) throws CartParameterException, CartBusinessException, CartNotFoundException{
        //empty cart if cartItemIds is null
        //there is a routine running at 12:PM to empty cart
        //code
        return FarmResponse.success();
    }
}
