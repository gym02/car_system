package com.gym.test.pojo;

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
public class DamageInformation {
    private Integer damageInformationId;
    private Integer orderId;
    private String contractNumber;
//    订购及返回时车照
    private com.gym.test.pojo.File carImg;
    private com.gym.test.pojo.File returnImg;
//    损坏
    private String  damageState;
    private String detail;
    private Integer isdelete;
}
