package com.gym.test.mapper;

import com.gym.test.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface CarMapper {
    @Select("select car_state from cars where car_id=#{id}")
   String getCarState(Integer id);

    List<Car> getCars();

    @Insert("insert into cars values (null,#{carState},#{brand},#{licensePlateNumber}," +
            "#{carModel},#{price},#{registTime},#{startMileage},#{carImg.id},0)")
    @Options(useGeneratedKeys = true,keyProperty = "carId",keyColumn = "carId")
    void addCar(Car car);

    @Update("update cars set isdelete=1 where car_id=#{carId}")
    void removeCar(Integer carId);

    @Update("update cars set car_state=#{carState},brand=#{brand},license_plate_number=#{licensePlateNumber}," +
            "car_model=#{carModel},price=#{price},regist_time=#{registTime},start_mileage=#{startMileage},car_img=#{carImg.id}" +
            " where car_id=#{carId}")
    void updateCar(Car car);

    @Select("select car_id from cars where license_plate_number=#{licensePlateNumber} and isdelete=0")
    Integer getCarId(String licensePlateNumber);

    @Select("select * from cars where car_id=#{id} and isdelete=0")
    Car getCarDetail(Integer id);

    @Update("update cars set start_mileage = #{endMileage} where car_id=#{id}")
    void updateStartMileage(@Param("id") Integer id ,@Param("endMileage") Double endMileage);

    @Update("update cars set car_state='待出租' where car_id=#{id}")
    void updateCarState(Integer id);

    @Update("update cars set car_state='已出租' where car_id=#{id}")
    void updateCarState2(Integer id);

    List<Car> getSearchCars(Car car);
}
