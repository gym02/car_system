package com.gym.test.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private Integer userId;
    private Integer carId;
    //本类属性
    private String orderState;
    //从user表读取
    private String name;
    //从user表读取
    private String tel;
    //从car表读取
    private String licensePlateNumber;
    //从car表读取
    private Double price;
    //本类属性，可修改
    private Double deposit;
    //自动算出，无需修改
    private Double totalPrice;
    //本类属性
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date startTime;
    //本类属性
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date endTime;
    //从car表读出
    private Double startMileage;
    //本类属性
    private Double endMileage;
    //本类属性
    private String contractNumber;
    private Integer isdelete;
}
