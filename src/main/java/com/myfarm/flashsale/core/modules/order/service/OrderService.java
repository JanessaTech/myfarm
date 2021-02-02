package com.myfarm.flashsale.core.modules.order.service;

import com.github.pagehelper.PageInfo;
import com.myfarm.flashsale.core.modules.order.dto.OrderDetailDto;
import com.myfarm.flashsale.core.modules.order.dto.OrderDto;
import com.myfarm.flashsale.core.modules.order.dto.filter.OrderDetailFilter;
import com.myfarm.flashsale.core.modules.order.dto.filter.OrderFilter;
import com.myfarm.flashsale.core.modules.order.exception.OrderBusinessException;
import com.myfarm.flashsale.core.modules.order.exception.OrderNotFoundException;
import com.myfarm.flashsale.core.modules.order.exception.OrderParameterException;

import java.util.List;

public interface OrderService {
    /**
     * the items specified by cartItemIds should be deleted after order confirmation saying yes
     * @param cartItemIds the items which are used to create an order
     * @return the order_id
     * @throws OrderParameterException
     * @throws OrderBusinessException
     * @throws OrderNotFoundException
     */
    String createOrder(List<String> cartItemIds, OrderDto orderDto) throws OrderParameterException, OrderBusinessException, OrderNotFoundException;
    PageInfo<List<OrderDto>> getOrdersByFilter(OrderFilter orderFilter, int page, int pageSize) throws OrderParameterException, OrderBusinessException, OrderNotFoundException;
    PageInfo<List<OrderDetailDto>> getOrderDetails(OrderDetailFilter orderDetailFilter) throws OrderParameterException, OrderBusinessException, OrderNotFoundException;
    void deleteOrderById(String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException;
    void updateOrderStatus(String newStatus, String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException;
    void updateOrderPaymentId(String paymentId, String orderId) throws OrderParameterException, OrderBusinessException, OrderNotFoundException;
}
