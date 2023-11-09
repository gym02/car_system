package com.gym.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
        String str = "^[1-9]+[0,1,2,3,4,5,6,7,8,9]{4,14}";
        String QQNumber = "12345";
        boolean pattern = Pattern.matches(str,QQNumber);
        System.out.println(pattern);
    }

}
