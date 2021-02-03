package com.myfarm.flashsale.core.modules.cart.service.imp;

import com.myfarm.flashsale.core.modules.cart.dto.CartDto;
import com.myfarm.flashsale.core.modules.cart.dto.filter.CartFilter;
import com.myfarm.flashsale.core.modules.cart.exception.CartBusinessException;
import com.myfarm.flashsale.core.modules.cart.exception.CartNotFoundException;
import com.myfarm.flashsale.core.modules.cart.exception.CartParameterException;
import com.myfarm.flashsale.core.modules.cart.repository.mappers.CartMapper;
import com.myfarm.flashsale.core.modules.cart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImp implements CartService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;
    @Resource
    private CartMapper cartMapper;

    @Override
    public List<CartDto> getCartContent(CartFilter cartFilter) throws CartParameterException, CartBusinessException, CartNotFoundException {
        return null;
    }

    @Override
    public void updateCartContent(String userId, List<CartDto> cartDtos) throws CartParameterException, CartBusinessException, CartNotFoundException {

    }

    @Override
    public void deleteCartContentById(List<String> cartItemIds) throws CartParameterException, CartBusinessException, CartNotFoundException {

    }
}
