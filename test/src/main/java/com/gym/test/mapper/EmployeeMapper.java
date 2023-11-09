package com.gym.test.mapper;

import com.gym.test.pojo.Employee;
import com.gym.test.pojo.dto.EmployeePageDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employees where username=#{username} and password=#{password} and isdelete=0")
    Employee getEmployee(Employee employee);

    void updateEmployee(@Param("employee") Employee employee);

    @Select("select * from employees where isdelete = 0")
    List<Employee> getEmployees();

    @Insert("insert into employees values (null,#{name},#{tel},#{username},#{password},0)")
    @Options(useGeneratedKeys = true,keyColumn = "employeeId",keyProperty = "employeeId")
    void addEmployee(Employee employee);

    @Update("update employees set isdelete=1 where employee_id=#{employeeId}")
    void remove(Integer employeeId);

    List<Employee> getSearchEmployees(Employee employee);
}
