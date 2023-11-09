package com.gym.test.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExportDto {
    private Integer userId;
    private String name;
    private Integer age;
    private String tel;
    private String idNumber;
    private Integer isdelete;
    private Integer pageNum;
    private Integer pageSize;
}
