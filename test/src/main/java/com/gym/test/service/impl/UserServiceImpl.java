package com.gym.test.service.impl;

import com.gym.test.mapper.UserMapper;
import com.gym.test.pojo.User;
import com.gym.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void removeUser(Integer userId) {
        userMapper.removeUser(userId);
    }

    @Override
    public Integer getUserId(String name, String tel) {
        return userMapper.getUserId(name,tel);
    }

    @Override
    public List<User> getSearchUsers(User user) {
        return userMapper.getSearchEmployees(user);
    }
}
