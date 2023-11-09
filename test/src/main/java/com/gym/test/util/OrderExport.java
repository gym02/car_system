package com.gym.test.util;

import com.gym.test.pojo.Car;
import com.gym.test.pojo.dto.OrderDto;
import com.gym.test.pojo.dto.OrderExportDto;
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
public class OrderExport extends AbstractXlsxView {
    @Autowired
    MyUtil myUtil;
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet sheet = workbook.createSheet("订单信息表");
        //表头
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("订单id");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("状态");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("姓名");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue("电话");
        Cell cell4 = row.createCell(4);
        cell4.setCellValue("车牌号");
        Cell cell5 = row.createCell(5);
        cell5.setCellValue("价格");
        Cell cell6 = row.createCell(6);
        cell6.setCellValue("押金");
        Cell cell7 = row.createCell(7);
        cell7.setCellValue("总价");
        Cell cell8 = row.createCell(8);
        cell8.setCellValue("开始时间");
        Cell cell9 = row.createCell(9);
        cell9.setCellValue("结束时间");
        Cell cell10 = row.createCell(10);
        cell10.setCellValue("开始里程");
        Cell cell11 = row.createCell(11);
        cell11.setCellValue("结束里程");
        Cell cell12 = row.createCell(12);
        cell12.setCellValue("合同编号");
        //取出map中的数据
        List<OrderDto> emps = (List<OrderDto>) model.get("orders");
        //遍历
        for (int i = 0; i < emps.size(); i++) {
            OrderDto e = emps.get(i);
            //为每一个对象创建一个行
            Row row1 = sheet.createRow(i + 1);
            Cell cell101 = row1.createCell(0);
            cell101.setCellValue(e.getOrderId());
            Cell cell102 = row1.createCell(1);
            cell102.setCellValue(e.getOrderState());
            Cell cell103 = row1.createCell(2);
            cell103.setCellValue(e.getName());
            Cell cell1031 = row1.createCell(3);
            cell1031.setCellValue(e.getTel());
            Cell cell104 = row1.createCell(4);
            cell104.setCellValue(e.getLicensePlateNumber());
            Cell cell105 = row1.createCell(5);
            cell105.setCellValue(e.getPrice());
            Cell cell106 = row1.createCell(6);
            cell106.setCellValue(e.getDeposit());
            Cell cell107 = row1.createCell(7);
            cell107.setCellValue(e.getTotalPrice());
            Cell cell108 = row1.createCell(8);
            cell108.setCellValue(myUtil.dateToStr(e.getStartTime()));
            Cell cell109 = row1.createCell(9);
            cell109.setCellValue(myUtil.dateToStr(e.getEndTime()));
            Cell cell110 = row1.createCell(10);
            cell110.setCellValue(e.getStartMileage());
            Cell cell111 = row1.createCell(11);
            cell111.setCellValue(e.getEndMileage());
            Cell cell112 = row1.createCell(12);
            cell112.setCellValue(e.getContractNumber());
        }
    }
}
