package com.gym.test.mapper;

import com.gym.test.pojo.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface FileMapper {
    @Insert("insert into files values (#{id},#{path},#{md5})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void insert(File file);

    @Select("select * from files where md5 = #{md5}")
    public File select(String md5);

    @Select("select * from files where id = #{id}")
    File getById(int id);
}
