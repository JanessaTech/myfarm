package com.myfarm.flashsale.core.modules.cart.service;

import com.myfarm.flashsale.core.modules.cart.dto.CartDto;
import com.myfarm.flashsale.core.modules.cart.dto.filter.CartFilter;
import com.myfarm.flashsale.core.modules.cart.exception.CartBusinessException;
import com.myfarm.flashsale.core.modules.cart.exception.CartNotFoundException;
import com.myfarm.flashsale.core.modules.cart.exception.CartParameterException;

import java.util.List;

public interface CartService {
    List<CartDto> getCartContent(CartFilter cartFilter) throws CartParameterException, CartBusinessException, CartNotFoundException;
    void updateCartContent(String userId, List<CartDto> cartDtos) throws CartParameterException, CartBusinessException, CartNotFoundException;
    void deleteCartContentById(List<String> cartItemIds) throws CartParameterException, CartBusinessException, CartNotFoundException;
}
