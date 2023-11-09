package com.gym.test.service.impl;

import com.gym.test.mapper.CarBrandMapper;
import com.gym.test.pojo.CarBrand;
import com.gym.test.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class CarBrandServiceImpl implements CarBrandService {
    @Autowired
    CarBrandMapper carBrandMapper;
    @Override
    public List<CarBrand> getBrands() {
        return carBrandMapper.getBrands();
    }
}
