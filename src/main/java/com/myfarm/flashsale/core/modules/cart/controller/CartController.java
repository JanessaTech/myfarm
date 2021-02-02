package com.myfarm.flashsale.core.modules.cart.controller;

import com.myfarm.flashsale.core.modules.cart.dto.CartDto;
import com.myfarm.flashsale.core.modules.cart.exception.CartBusinessException;
import com.myfarm.flashsale.core.modules.cart.exception.CartNotFoundException;
import com.myfarm.flashsale.core.modules.cart.exception.CartParameterException;
import com.myfarm.flashsale.core.modules.cart.service.CartService;
import com.myfarm.flashsale.core.modules.common.FarmResponse;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "", tags = "cart")
@Validated
@RestController
@RequestMapping("/cartItems")
public class CartController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CartService cartService;


    public FarmResponse<List<CartDto>> getCartContentByUserId(String userId) throws CartParameterException, CartBusinessException, CartNotFoundException{
        //code
        return null;
    }
    public FarmResponse<Object> updateCartContent(List<CartDto> cartDtos) throws CartParameterException, CartBusinessException, CartNotFoundException{
        return FarmResponse.success();
    }

    public FarmResponse<Object> deleteCartContentById(String cartItemIds) throws CartParameterException, CartBusinessException, CartNotFoundException{
        return FarmResponse.success();
    }
}
