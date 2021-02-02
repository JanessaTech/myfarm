package com.myfarm.flashsale.core.modules.order.service.imp;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.order.dto.OrderDetailDto;
import com.myfarm.flashsale.core.modules.order.dto.OrderDto;
import com.myfarm.flashsale.core.modules.order.dto.filter.OrderDetailFilter;
import com.myfarm.flashsale.core.modules.order.dto.filter.OrderFilter;
import com.myfarm.flashsale.core.modules.order.exception.OrderBusinessException;
import com.myfarm.flashsale.core.modules.order.exception.OrderNotFoundException;
import com.myfarm.flashsale.core.modules.order.exception.OrderParameterException;
import com.myfarm.flashsale.core.modules.order.repository.mappers.OrderMapper;
import com.myfarm.flashsale.core.modules.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSource messageSource;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public String createOrder(List<String> cartItemIds, OrderDto orderDto) throws OrderParameterException, OrderBusinessException, OrderNotFoundException {
        return null;
    }

    @Override
    public PageInfo<List<OrderDto>> getOrdersByFilter(OrderFilter orderFilter, int page, int pageSize) throws OrderParameterException, OrderBusinessException, OrderNotFoundException {
        return null;
    }

    @Override
    public PageInfo<List<OrderDetailDto>> getOrderDetails(OrderDetailFilter orderDetailFilter) throws OrderParameterException, OrderBusinessException, OrderNotFoundException {
        return null;
    }

    @Override
    public void deleteOrderById(String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException {

    }

    @Override
    public void updateOrderStatus(String newStatus, String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException {

    }

    @Override
    public void updateOrderPaymentId(String paymentId, String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException {

    }
}
