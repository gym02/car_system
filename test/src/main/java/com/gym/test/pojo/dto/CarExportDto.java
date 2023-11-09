package com.gym.test.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarExportDto {
    private Integer carId;
    private String carState;
    private String brand;
    //    车牌号
    private String licensePlateNumber;
    //    汽车型号
    private String carModel;
    private Double price;
    //    该车购入公司的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    private Date registTime;
    private Double startMileage;
    private com.gym.test.pojo.File carImg;
    private Integer isdelete;
    private Integer pageNum;
    private Integer pageSize;
}
