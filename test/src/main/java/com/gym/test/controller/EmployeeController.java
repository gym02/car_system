package com.gym.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.test.pojo.Employee;
import com.gym.test.pojo.dto.EmployeeExportDto;
import com.gym.test.pojo.dto.EmployeePageDto;
import com.gym.test.service.EmployeeService;
import com.gym.test.util.ResponseEntity;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author 高垚淼
 * @version 1.0
 */
@SessionAttributes(value = {"employee","admin"})
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //======================================================================================增删改
//登录验证。密码加盐，自动登录，鉴权
    @ResponseBody
    @PostMapping("/login")
    public Object login(@RequestBody Employee employee, Map map, HttpSession session, HttpServletResponse response) {
        Employee employee1 = employeeService.getEmployee(employee);
        if (employee1 != null) {
            if("admin".equals(employee1.getUsername())){
                map.put("employee", employee1);
                map.put("admin", employee1);
                //响应一个cookie实现自动登录
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setPath("/");
                cookie.setMaxAge(86400 * 3);
                response.addCookie(cookie);
                return new ResponseEntity(201, "管理员登录成功", employee);
            }else{
                map.put("employee", employee1);
                //响应一个cookie实现自动登录
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setPath("/");
                cookie.setMaxAge(86400 * 3);
                response.addCookie(cookie);
                return new ResponseEntity(200, "员工登录成功", employee);
            }
        } else {
            return new ResponseEntity(400, "用户名或密码错误", null);
        }
    }

    //查询所有
    @ResponseBody
    @PostMapping("/getEmployees")
    public Object getEmployees(@RequestBody EmployeePageDto employeePageDto) {
        PageHelper.startPage(employeePageDto.getPageNum(), employeePageDto.getPageSize());
        List<Employee> employees = employeeService.getEmployees();
        PageInfo pageInfo = new PageInfo(employees);
        return new ResponseEntity(200, "所有员工信息", pageInfo);
    }

    //添加员工
    @ResponseBody
    @PostMapping("/addEmployee")
    public Object addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity(200, "添加成功", employee);
    }

    //删除员工
    @ResponseBody
    @PostMapping("/removeEmployee/{employeeId}")
    public Object removeEmployee(@PathVariable Integer employeeId) {
        System.out.println("--------------------" + employeeId);
        employeeService.remove(employeeId);
        return new ResponseEntity(200, "删除成功", null);
    }

    //修改员工
    @ResponseBody
    @PostMapping("/updateEmployee")
    public Object updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity(200, "修改成功", employee);
    }

    //密码加盐
    @Value("${password-salt}")
    String salt;

    @ResponseBody
    @GetMapping("/salt")
    public Object salt() {
        return new ResponseEntity(200, "salt", salt);
    }

    //============================================================================================搜索
//  搜索框查询
    @ResponseBody
    @PostMapping("/getSearchEmployees")
    public Object getSearchEmployees(@RequestBody Employee employee) {
        List<Employee> employees = employeeService.getSearchEmployees(employee);
        return new ResponseEntity(200, "搜索到的员工信息", employees);
    }
// ===========================================================================================导出
//  根据搜索条件导出excel表格
    @GetMapping("/export")
    public Object export(EmployeeExportDto employeeExportDto, Map map) throws IOException {
        PageHelper.startPage(employeeExportDto.getPageNum(),employeeExportDto.getPageSize());
        Employee employee = new Employee(employeeExportDto.getEmployeeId(),employeeExportDto.getName(),
                employeeExportDto.getTel(),null,null,0);
        List<Employee> employees = employeeService.getSearchEmployees(employee);
        map.put("employees",employees);
        return "employeeExport";
    }
    // ===========================================================================================测试
   @ResponseBody
    @PostMapping("/all")
    public Object all(){
        List<Employee> employees = employeeService.getEmployees();
        return employees;
    }
}
