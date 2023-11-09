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
public class EmployeeExportDto {
    private Integer employeeId;
    private String name;
    private String tel;
    private String username;
    private String password;
    private Integer isdelete;
    private Integer pageNum;
    private Integer pageSize;
}
