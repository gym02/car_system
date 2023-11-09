package com.gym.test.configrution;

import com.gym.test.interceptor.AdminLoginInterceptor;
import com.gym.test.interceptor.EmployeeLoginInterceptor;
import com.gym.test.util.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Configuration
public class WebConf implements WebMvcConfigurer {
    /**
     * 添加拦截器，进行登录鉴权
     * @param registry
     */
    @Autowired
    EmployeeLoginInterceptor employeeLoginInterceptor;
    @Autowired
    AdminLoginInterceptor adminLoginInterceptor;
    @Autowired
    DateConverter dateConverter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registration1 = registry.addInterceptor(employeeLoginInterceptor);
//        //指定拦截器1,对登录管理系统页要拦截的请求(支持*通配符)
//        registration1.addPathPatterns("/**/*")
//                     .excludePathPatterns(
//                        "/employee/login",
//                        "/employee/salt",
//                        "/images/girl.mp4",
//                        "/login.html",
//                        "/**/*.js",
//                        "/**/*.css",
//                        "/**/*.woff",
//                        "/**/*.jpeg",
//                        "/**/*.png",
//                        "/**/*.jpg");
//        //注册拦截器2，对超登录超级管理页进行权限验证
//        InterceptorRegistration registration2 = registry.addInterceptor(adminLoginInterceptor);
//        registration2.addPathPatterns("/index.html")
//                    .excludePathPatterns(
//                            "/employee/login",
//                            "/employee/salt");
    }

    @Bean
    public ViewResolver viewResolver(){
        BeanNameViewResolver viewResolver = new BeanNameViewResolver();
        return viewResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
        WebMvcConfigurer.super.addFormatters(registry);
    }
}
