package com.gym.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.test.pojo.Employee;
import com.gym.test.pojo.User;
import com.gym.test.pojo.dto.EmployeeExportDto;
import com.gym.test.pojo.dto.UserExportDto;
import com.gym.test.pojo.dto.UserPageDto;
import com.gym.test.service.UserService;
import com.gym.test.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //    ============================================================================增删改
    //获得所有用户
    @ResponseBody
    @PostMapping("/getUsers")
    public Object getUsers(@RequestBody UserPageDto userPageDto) {
        PageHelper.startPage(userPageDto.getPageNum(), userPageDto.getPageSize());
        List<User> users = userService.getUsers();
        PageInfo pageInfo = new PageInfo(users);
        return new ResponseEntity(200, "所有用户信息", pageInfo);
    }

    //添加用户
    @ResponseBody
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity(200, "添加成功", user);
    }

    //删除用户
    @ResponseBody
    @PostMapping("/removeUser/{userId}")
    public Object removeUser(@PathVariable Integer userId) {
        userService.removeUser(userId);
        return new ResponseEntity(200, "删除成功", null);
    }

    //修改用户
    @ResponseBody
    @PostMapping("/updateUser")
    public Object updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity(200, "修改成功", user);
    }

    //通过姓名和电话获取userId
    @ResponseBody
    @PostMapping("/getUserId")
    public Object getUserId(@RequestBody User user) {
        Integer userId = userService.getUserId(user.getName(), user.getTel());
        if (userId != null) {
            return new ResponseEntity(200, "用户id", userId);
        } else {
            return new ResponseEntity(400, "没有此人", null);
        }
    }

    //    ================================================================================搜索
//   根据搜索查询用户信息
    @ResponseBody
    @PostMapping("/getSearchUsers")
    public Object getSearchUsers(@RequestBody User user) {
        List<User> users = userService.getSearchUsers(user);
        return new ResponseEntity(200, "搜索到的用户信息", users);
    }

    // ===========================================================================================导出
//  根据搜索条件导出excel表格
    @GetMapping("/export")
    public Object export(UserExportDto userExportDto, Map map) throws IOException {
        PageHelper.startPage(userExportDto.getPageNum(), userExportDto.getPageSize());
        User user = new User(userExportDto.getUserId(), userExportDto.getName(), userExportDto.getAge(),
                userExportDto.getTel(), userExportDto.getIdNumber(), 0);
        List<User> users = userService.getSearchUsers(user);
        map.put("users", users);
        return "userExport";
    }
}
