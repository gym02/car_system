package com.gym.test.util;

import com.gym.test.pojo.Car;
import com.gym.test.pojo.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CarExport extends AbstractXlsxView {
    @Autowired
    MyUtil myUtil;
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet sheet = workbook.createSheet("汽车信息表");
        //表头
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("汽车id");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("状态");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("车牌号");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue("品牌");
        Cell cell4 = row.createCell(4);
        cell4.setCellValue("类型");
        Cell cell5 = row.createCell(5);
        cell5.setCellValue("价格￥/天");
        Cell cell6 = row.createCell(6);
        cell6.setCellValue("起始里程");
        Cell cell7 = row.createCell(7);
        cell7.setCellValue("汽车注册时间");
        //取出map中的数据
        List<Car> emps = (List<Car>) model.get("cars");
        //遍历
        for (int i = 0; i < emps.size(); i++) {
            Car e = emps.get(i);
            //为每一个对象创建一个行
            Row row1 = sheet.createRow(i + 1);
            Cell cell10 = row1.createCell(0);
            cell10.setCellValue(e.getCarId());
            Cell cell11 = row1.createCell(1);
            cell11.setCellValue(e.getCarState());
            Cell cell12 = row1.createCell(2);
            cell12.setCellValue(e.getLicensePlateNumber());
            Cell cell13 = row1.createCell(3);
            cell13.setCellValue(e.getBrand());
            Cell cell14 = row1.createCell(4);
            cell14.setCellValue(e.getCarModel());
            Cell cell15 = row1.createCell(5);
            cell15.setCellValue(e.getPrice());
            Cell cell16 = row1.createCell(6);
            cell16.setCellValue(e.getStartMileage());
            Cell cell17 = row1.createCell(7);
            cell17.setCellValue(myUtil.dateToStr(e.getRegistTime()));
        }
    }
}
