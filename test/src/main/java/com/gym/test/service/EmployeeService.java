package com.gym.test.service;


import com.gym.test.pojo.Employee;
import com.gym.test.pojo.dto.EmployeePageDto;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface EmployeeService {
    public List<Employee> getEmployees();
    public Employee getEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    void addEmployee(Employee employee);

    void remove(Integer employeeId);

    List<Employee> getSearchEmployees(Employee employee);
}
