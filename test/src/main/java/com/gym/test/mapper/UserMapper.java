package com.gym.test.mapper;

import com.gym.test.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface UserMapper {

    @Select("select * from users where isdelete=0")
    List<User> getUsers();

    @Update("update users set name=#{user.name},age=#{user.age},tel=#{user.tel},id_number=#{user.idNumber} where user_id=#{user.userId}")
    void updateUser(@Param("user") User user);

    @Insert("insert into users values (null,#{name},#{age},#{tel},#{idNumber},0)")
    @Options(useGeneratedKeys = true,keyColumn = "userId",keyProperty = "userId")
    void addUser(User user);

    @Update("update users set isdelete=1 where user_id=#{userId}")
    void removeUser(Integer userId);

    @Select("select user_id from users where name=#{name} and tel=#{tel} and isdelete=0")
    Integer getUserId(@Param("name") String name,@Param("tel") String tel);

    List<User> getSearchEmployees(User user);
}
