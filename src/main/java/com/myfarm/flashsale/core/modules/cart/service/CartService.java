package com.myfarm.flashsale.core.modules.cart.service;

import com.myfarm.flashsale.core.modules.cart.dto.CartDto;
import com.myfarm.flashsale.core.modules.cart.exception.CartBusinessException;
import com.myfarm.flashsale.core.modules.cart.exception.CartNotFoundException;
import com.myfarm.flashsale.core.modules.cart.exception.CartParameterException;

import java.util.List;

public interface CartService {
    /**
     * Return cart info for a specific user. sort result by add_Cart_date in ascending order
     * @param userId
     * @return
     * @throws CartParameterException
     * @throws CartBusinessException
     * @throws CartNotFoundException
     */
    List<CartDto> getCartContentByUserId(String userId) throws CartParameterException, CartBusinessException, CartNotFoundException;

    /**
     * Return cart info for a set of cartItemId
     * @param cartItemIds
     * @return
     * @throws CartParameterException
     * @throws CartBusinessException
     * @throws CartNotFoundException
     */
    List<CartDto> getCartContentByCartItemIds(List<String> cartItemIds) throws CartParameterException, CartBusinessException, CartNotFoundException;

    /**
     * update cart by using cartDtos which are changed items
     * @param cartDtos
     * @throws CartParameterException
     * @throws CartBusinessException
     * @throws CartNotFoundException
     */
    void updateCartContent(List<CartDto> cartDtos) throws CartParameterException, CartBusinessException, CartNotFoundException;

    /**
     * delete some items in cart by cartItemIds
     * @param cartItemIds
     * @throws CartParameterException
     * @throws CartBusinessException
     * @throws CartNotFoundException
     */
    void deleteCartContentById(List<String> cartItemIds) throws CartParameterException, CartBusinessException, CartNotFoundException;

    /**
     * empty cart at 12:00 PM
     * @throws CartParameterException
     * @throws CartBusinessException
     * @throws CartNotFoundException
     */
    void emptyCart() throws CartParameterException, CartBusinessException, CartNotFoundException;
}
