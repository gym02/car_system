package com.gym.test.util;

import com.gym.test.pojo.Employee;
import com.gym.test.pojo.User;
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
public class UserExport extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet sheet = workbook.createSheet("用户信息表");
        //表头
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("用户id");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("姓名");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("年龄");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue("电话号");
        Cell cell4 = row.createCell(4);
        cell4.setCellValue("身份证号");
        //取出map中的数据
        List<User> emps = (List<User>) model.get("users");
        //遍历
        for (int i = 0; i < emps.size(); i++) {
            User e = emps.get(i);
            //为每一个对象创建一个行
            Row row1 = sheet.createRow(i + 1);
            Cell cell10 = row1.createCell(0);
            cell10.setCellValue(e.getUserId());
            Cell cell11 = row1.createCell(1);
            cell11.setCellValue(e.getName());
            Cell cell12 = row1.createCell(2);
            cell12.setCellValue(e.getAge());
            Cell cell13 = row1.createCell(3);
            cell13.setCellValue(e.getTel());
            Cell cell14 = row1.createCell(4);
            cell14.setCellValue(e.getIdNumber());
        }
    }
}
