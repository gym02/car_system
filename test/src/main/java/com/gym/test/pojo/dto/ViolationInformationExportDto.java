package com.gym.test.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViolationInformationExportDto {
    private Integer violationInformationId;
    private String contractNumber;
    //    已处理、待处理、处理中
    private String violationState;
    //    罚款
    private Double penalty;
    private String detail;
    private String violationLocation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date violationTime;
    private Integer pageNum;
    private Integer pageSize;
}
