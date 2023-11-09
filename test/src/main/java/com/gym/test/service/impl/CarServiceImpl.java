package com.gym.test.service.impl;

import com.gym.test.mapper.CarMapper;
import com.gym.test.pojo.Car;
import com.gym.test.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;
    @Override
    public List<Car> getCars() {
        return carMapper.getCars();
    }

    @Override
    public void addCar(Car car) {
        carMapper.addCar(car);
    }

    @Override
    public void removeCar(Integer carId) {
        carMapper.removeCar(carId);
    }

    @Override
    public void updateCar(Car car) {
        carMapper.updateCar(car);
    }

    @Override
    public Integer getCarId(String licensePlateNumber) {
        return carMapper.getCarId(licensePlateNumber);
    }

    @Override
    public Car getCarDetail(Integer id) {
        return carMapper.getCarDetail(id);
    }

    @Override
    public String getCarState(Integer id) {
        return carMapper.getCarState(id);
    }

    @Override
    public void updateStartMileage(Integer id, Double endMileage) {
        carMapper.updateStartMileage(id,endMileage);
    }

    @Override
    public void updateCarState(Integer id) {
        carMapper.updateCarState(id);
    }

    @Override
    public void updateCarState2(Integer id) {
        carMapper.updateCarState2(id);
    }

    @Override
    public List<Car> getSearchCars(Car car) {
        return carMapper.getSearchCars(car);
    }
}
