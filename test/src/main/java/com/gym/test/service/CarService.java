package com.gym.test.service;

import com.gym.test.pojo.Car;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface CarService {
    List<Car> getCars();

    void addCar(Car car);

    void removeCar(Integer carId);

    void updateCar(Car car);

    Integer getCarId(String licensePlateNumber);

    Car getCarDetail(Integer id);

    String getCarState(Integer id);

    void updateStartMileage(Integer id ,Double endMileage);

    void updateCarState(Integer id);

    void updateCarState2(Integer id);

    List<Car> getSearchCars(Car car);
}
