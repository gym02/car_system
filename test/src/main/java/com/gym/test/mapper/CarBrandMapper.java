package com.gym.test.mapper;

import com.gym.test.pojo.CarBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface CarBrandMapper {

    @Select("select * from car_brand")
    List<CarBrand> getBrands();
}
