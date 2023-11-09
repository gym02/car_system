package com.gym.test.service;

import com.gym.test.pojo.Order;
import com.gym.test.pojo.dto.OrderDto;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface OrderService {
    List<OrderDto> getOrders();

    void addOrder(OrderDto order);

    void removeOrder(Integer orderId);

    void updateOrder(OrderDto orderDto);

    OrderDto getContractNumber(String contractNumber);

    Order getContractNumberNoReturns(String contractNumber);

    List<OrderDto> getSearchOrders(OrderDto orderDto);
}
