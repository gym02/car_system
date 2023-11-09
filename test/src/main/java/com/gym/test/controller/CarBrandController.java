package com.gym.test.controller;

import com.gym.test.pojo.CarBrand;
import com.gym.test.service.CarBrandService;
import com.gym.test.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@RestController
@RequestMapping("/carBrand")
public class CarBrandController {
    @Autowired
    CarBrandService carBrandService;

    @GetMapping("/getBrands")
    public Object getBrands(){
        List<CarBrand> carBrands = carBrandService.getBrands();
        List<String> carBrandsName = new ArrayList<>();
        for (CarBrand c :carBrands) {
            carBrandsName.add(c.getBrandName());
        }
        return new ResponseEntity(200,"所有品牌",carBrandsName);
    }
}
