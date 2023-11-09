package com.gym.test.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Component
public class MyUtil {
    public String dateToStr(Date date){
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy年MM月dd日");
        String format = sdf.format(date);
        return format;
    }
}
