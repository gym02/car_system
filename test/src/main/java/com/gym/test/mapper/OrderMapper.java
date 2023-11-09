package com.gym.test.mapper;

import com.gym.test.pojo.Order;
import com.gym.test.pojo.dto.OrderDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface OrderMapper {
    List<OrderDto> getOrders();


    @Insert(" insert into orders values (null,#{userId},#{carId},#{orderState},#{price},#{deposit},#{totalPrice},#{startTime}," +
            "#{endTime},#{endMileage},#{endMileage},#{contractNumber},0)")
    @Options(useGeneratedKeys = true,keyProperty = "orderId",keyColumn = "orderId")
    void addOrder(OrderDto order);

    @Update("update orders set isdelete=1 where order_id=#{orderId}")
    void removeOrder(Integer orderId);

    @Update("update orders set order_state=#{orderState},contract_number=#{contractNumber}," +
            "deposit=#{deposit},total_price=#{totalPrice},start_time=#{startTime},end_time=#{endTime},end_mileage=#{endMileage} where order_id=#{orderId}")
    void updateOrder(OrderDto orderDto);
    OrderDto getContractNumber(String contractNumber);

    @Select("select * from orders where contract_number=#{contractNumber}")
    Order getContractNumberNoReturns(String contractNumber);

    List<OrderDto> getSearchEmployees(OrderDto orderDto);
}
