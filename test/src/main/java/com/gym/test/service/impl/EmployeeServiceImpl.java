package com.gym.test.service.impl;

import com.gym.test.mapper.EmployeeMapper;
import com.gym.test.pojo.Employee;
import com.gym.test.pojo.dto.EmployeePageDto;
import com.gym.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeMapper.getEmployees();
    }

    @Override
    public Employee getEmployee(Employee employee) {
        return employeeMapper.getEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void remove(Integer employeeId) {
        employeeMapper.remove(employeeId);
    }

    @Override
    public List<Employee> getSearchEmployees(Employee employee) {
        return employeeMapper.getSearchEmployees(employee);
    }
}
