package com.gym.test.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gym.test.util.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        if(admin == null){
            PrintWriter out = response.getWriter();
            //创建一个响应对象
            ResponseEntity responseEntity = new ResponseEntity(400,"not admin",null);
            ObjectMapper objectMapper = new ObjectMapper();
            //转为json
            String s = objectMapper.writeValueAsString(responseEntity);
            //响应给前端
            out.write(s);
            out.close();
            return false;
        }
        return true;
    }
}
