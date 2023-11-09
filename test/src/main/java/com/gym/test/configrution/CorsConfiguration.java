package com.gym.test.configrution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//配置允许跨域的请求
                        .allowedOrigins("*")      //配置允许跨域的域名
                        .allowedHeaders("*")      //配置允许跨域携带请求头信息
                        .allowedMethods("*") ;       //配置允许跨域的请求类型 POST GET DELETE PUT      Restful
            }
        };
    }
}
