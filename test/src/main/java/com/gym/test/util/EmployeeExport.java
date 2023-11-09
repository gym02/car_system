package com.gym.test.util;

import com.gym.test.pojo.Employee;
import com.gym.test.pojo.dto.EmployeeExportDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Component
public class EmployeeExport extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet sheet = workbook.createSheet("员工信息表");
        //表头
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("员工号");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("姓名");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("电话");
        //取出map中的数据
        List<Employee> emps = (List<Employee>) model.get("employees");
        //遍历
        for (int i = 0; i < emps.size(); i++) {
            Employee e = emps.get(i);
            //为每一个对象创建一个行
            Row row1 = sheet.createRow(i + 1);
            Cell cell10 = row1.createCell(0);
            cell10.setCellValue(e.getEmployeeId());
            Cell cell11 = row1.createCell(1);
            cell11.setCellValue(e.getName());
            Cell cell12 = row1.createCell(2);
            cell12.setCellValue(e.getTel());
        }
    }
}
