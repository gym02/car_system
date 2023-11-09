package com.gym.test.service.impl;

import com.gym.test.mapper.OrderMapper;
import com.gym.test.pojo.Order;
import com.gym.test.pojo.dto.OrderDto;
import com.gym.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderDto> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public void addOrder(OrderDto order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void removeOrder(Integer orderId) {
        orderMapper.removeOrder(orderId);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        orderMapper.updateOrder(orderDto);
    }

    @Transactional
    @Override
    public OrderDto getContractNumber(String contractNumber) {
        return orderMapper.getContractNumber(contractNumber);
    }

    @Override
    public Order getContractNumberNoReturns(String contractNumber) {
        return orderMapper.getContractNumberNoReturns(contractNumber);
    }

    @Override
    public List<OrderDto> getSearchOrders(OrderDto orderDto) {
        return orderMapper.getSearchEmployees(orderDto);
    }
}
