package com.gym.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.test.pojo.Car;
import com.gym.test.pojo.Order;
import com.gym.test.pojo.dto.CarExportDto;
import com.gym.test.pojo.dto.OrderDto;
import com.gym.test.pojo.dto.OrderExportDto;
import com.gym.test.pojo.dto.OrderPageDto;
import com.gym.test.service.OrderService;
import com.gym.test.util.ResponseEntity;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //==========================================================================增删改
    //获取所有汽车
    @ResponseBody
    @PostMapping("/getOrders")
    public Object getOrders(@RequestBody OrderPageDto orderPageDto) {
        PageHelper.startPage(orderPageDto.getPageNum(), orderPageDto.getPageSize());
        List<OrderDto> orders = orderService.getOrders();
        PageInfo pageInfo = new PageInfo(orders);
        return new ResponseEntity(200, "所有订单信息", pageInfo);
    }

    //添加订单
    @ResponseBody
    @PostMapping("/addOrder")
    public Object addOrder(@RequestBody OrderDto order) {
        Double totalPrice = order.getPrice() * (Math.ceil((order.getEndTime().getTime() -
                order.getStartTime().getTime()) / (double) (24 * 60 * 60 * 1000))) + order.getDeposit();
        order.setTotalPrice(totalPrice);
        orderService.addOrder(order);
        return new ResponseEntity(200, "添加成功", order);
    }

    //删除订单
    @ResponseBody
    @PostMapping("/removeOrder/{id}")
    public Object removeOrder(@PathVariable("id") Integer orderId) {
        orderService.removeOrder(orderId);
        return new ResponseEntity(200, "删除成功", null);
    }

    //修改订单
    @ResponseBody
    @PostMapping("/updateOrder")
    public Object updateOrder(@RequestBody OrderDto order) {
        Double totalPrice = order.getPrice() * (Math.ceil((order.getEndTime().getTime() -
                order.getStartTime().getTime()) / (double) (24 * 60 * 60 * 1000))) + order.getDeposit();
        order.setTotalPrice(totalPrice);
        orderService.updateOrder(order);
        return new ResponseEntity(200, "修改成功", order);
    }

    //根据合同编号查询order信息，方便赋值（因为合同号也可以修改）
    @ResponseBody
    @GetMapping("/getContractNumber/{contractNumber}")
    public Object getContractNumber(@PathVariable("contractNumber") String contractNumber) {
        System.out.println("============" + contractNumber);
        OrderDto order = orderService.getContractNumber(contractNumber);
        if (order != null) {
            return new ResponseEntity(200, "查询合同编号成功,返回合同id", order);
        } else {
            return new ResponseEntity(400, "查询合同编号失败", null);
        }
    }

    //根据合同编号查询id
    @ResponseBody
    @GetMapping("/getContractNumberNoReturns/{contractNumber}")
    public Object getContractNumberNoReturns(@PathVariable("contractNumber") String contractNumber) {
        Order order = orderService.getContractNumberNoReturns(contractNumber);
        if (order != null) {
            return new ResponseEntity(200, "查询合同编号成功,返回合同id", order.getOrderId());
        } else {
            return new ResponseEntity(400, "查询合同编号失败", null);
        }
    }

    // =================================================================================搜索
    //根据搜索查询订单信息
    @ResponseBody
    @PostMapping("/getSearchOrders")
    public Object getSearchOrders(@RequestBody OrderDto orderDto) {
        List<OrderDto> orders = orderService.getSearchOrders(orderDto);
        return new ResponseEntity(200, "搜索到的订单信息", orders);
    }

    // ===========================================================================================导出
//  根据搜索条件导出excel表格
    @GetMapping("/export")
    public Object export(OrderExportDto orderExportDto, Map map) throws IOException {
        PageHelper.startPage(orderExportDto.getPageNum(), orderExportDto.getPageSize());
        OrderDto order = new OrderDto(orderExportDto.getOrderId(),null,null,orderExportDto.getOrderState(),orderExportDto.getName(),
                orderExportDto.getTel(),orderExportDto.getLicensePlateNumber(),orderExportDto.getPrice(),
                orderExportDto.getDeposit(),orderExportDto.getTotalPrice(),orderExportDto.getStartTime(),
                orderExportDto.getEndTime(),orderExportDto.getStartMileage(),orderExportDto.getEndMileage(),
                orderExportDto.getContractNumber(),0);
        List<OrderDto> orders = orderService.getSearchOrders(order);
        map.put("orders", orders);
        return "orderExport";
    }
}
