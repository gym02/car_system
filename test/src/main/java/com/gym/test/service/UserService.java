package com.gym.test.service;

import com.gym.test.pojo.User;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface UserService {
    List<User> getUsers();

    void updateUser(User user);

    void addUser(User user);

    void removeUser(Integer userId);

    Integer getUserId(String name, String tel);

    List<User> getSearchUsers(User user);
}
