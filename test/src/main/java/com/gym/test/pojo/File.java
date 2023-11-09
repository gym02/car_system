package com.gym.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
    private Integer id;
    private String path;
    private String md5;
}
