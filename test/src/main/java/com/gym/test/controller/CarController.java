package com.gym.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.test.pojo.Car;
import com.gym.test.pojo.User;
import com.gym.test.pojo.dto.CarExportDto;
import com.gym.test.pojo.dto.CarPageDto;
import com.gym.test.pojo.dto.UpdateStartMileageDto;
import com.gym.test.pojo.dto.UserExportDto;
import com.gym.test.service.CarService;
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
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    //==================================================================================增删改
    //获取所有汽车
    @ResponseBody
    @PostMapping("/getCars")
    public Object getCars(@RequestBody CarPageDto carPageDto) {
        PageHelper.startPage(carPageDto.getPageNum(), carPageDto.getPageSize());
        List<Car> cars = carService.getCars();
        PageInfo pageInfo = new PageInfo(cars);
        return new ResponseEntity(200, "所有汽车信息", pageInfo);
    }

    //添加汽车
    @ResponseBody
    @PostMapping("/addCar")
    public Object addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity(200, "添加成功", car);
    }

    //删除汽车
    @ResponseBody
    @PostMapping("/removeCar/{carId}")
    public Object removeCar(@PathVariable Integer carId) {
        carService.removeCar(carId);
        return new ResponseEntity(200, "删除成功", null);
    }

    //修改汽车
    @ResponseBody
    @PostMapping("/updateCar")
    public Object updateCar(@RequestBody Car car) {
        carService.updateCar(car);
        return new ResponseEntity(200, "修改成功", car);
    }

    //查询汽车id
    @ResponseBody
    @PostMapping("/getCarId")
    public Object getCarId(@RequestBody Car car) {
        Integer carId = carService.getCarId(car.getLicensePlateNumber());
        if (carId != null) {
            return new ResponseEntity(200, "汽车id", carId);
        } else {
            return new ResponseEntity(400, "查无次车", null);
        }
    }

    //  查询汽车详情
    @ResponseBody
    @PostMapping("/getCarDetail/{id}")
    public Object getCarDetail(@PathVariable("id") Integer id) {
        Car car = carService.getCarDetail(id);
        return new ResponseEntity(200, "详细信息", car);
    }

    //  添加订单，获取该车的状态
    @ResponseBody
    @PostMapping("/getCarState/{id}")
    public Object getCarState(@PathVariable("id") Integer id) {
        String carState = carService.getCarState(id);
        return new ResponseEntity(200, "汽车状态", carState);
    }

    // 订单完成，修改汽车起始里程
    @ResponseBody
    @PostMapping("/updateStartMileage")
    public Object updateStartMileage(@RequestBody UpdateStartMileageDto updateStartMileageDto) {
        carService.updateStartMileage(updateStartMileageDto.getOrderId(), updateStartMileageDto.getEndMileage());
        return new ResponseEntity(200, "修改开始里程成功", null);
    }

    //  订单完成，修改汽车状态为待出租
    @ResponseBody
    @PostMapping("/updateCarState/{id}")
    public Object updateCarState(@PathVariable("id") Integer id) {
        carService.updateCarState(id);
        return new ResponseEntity(200, "修改状态为待出租成功", null);
    }

    //  添加订单，修改汽车状态为已出租
    @ResponseBody
    @PostMapping("/updateCarState2/{id}")
    public Object updateCarState2(@PathVariable("id") Integer id) {
        carService.updateCarState2(id);
        return new ResponseEntity(200, "修改状态为已出租成功", null);
    }

    //  ==================================================================================搜索
//  根据搜索查询所有汽车信息
    @ResponseBody
    @PostMapping("/getSearchCars")
    public Object getSearchCars(@RequestBody Car car) {
        List<Car> cars = carService.getSearchCars(car);
        return new ResponseEntity(200, "搜索到的汽车信息", cars);
    }

    // ===========================================================================================导出
//  根据搜索条件导出excel表格
    @GetMapping("/export")
    public Object export(CarExportDto carExportDto, Map map) throws IOException {
        PageHelper.startPage(carExportDto.getPageNum(), carExportDto.getPageSize());
        Car car = new Car(carExportDto.getCarId(),carExportDto.getCarState(),carExportDto.getLicensePlateNumber(),
                carExportDto.getBrand(),carExportDto.getCarModel(),carExportDto.getPrice(),
                carExportDto.getRegistTime(),carExportDto.getStartMileage(),null,0);
        List<Car> cars = carService.getSearchCars(car);
        map.put("cars", cars);
        return "carExport";
    }
}
