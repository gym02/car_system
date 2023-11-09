package com.gym.test.util;

import com.gym.test.pojo.Car;
import com.gym.test.pojo.ViolationInformation;
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
public class ViolationInformationExport extends AbstractXlsxView {
    @Autowired
    MyUtil myUtil;
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet sheet = workbook.createSheet("汽车违章信息表");
        //表头
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("id");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("合同编号");
        Cell cell2 = row.createCell(2);
        cell2.setCellValue("违章状态");
        Cell cell3 = row.createCell(3);
        cell3.setCellValue("违章罚款");
        Cell cell4 = row.createCell(4);
        cell4.setCellValue("详细信息");
        Cell cell5 = row.createCell(5);
        cell5.setCellValue("违章地点");
        Cell cell6 = row.createCell(6);
        cell6.setCellValue("违章时间");
        //取出map中的数据
        List<ViolationInformation> emps = (List<ViolationInformation>) model.get("violationInformations");
        //遍历
        for (int i = 0; i < emps.size(); i++) {
            ViolationInformation e = emps.get(i);
            //为每一个对象创建一个行
            Row row1 = sheet.createRow(i + 1);
            Cell cell10 = row1.createCell(0);
            cell10.setCellValue(e.getViolationInformationId());
            Cell cell11 = row1.createCell(1);
            cell11.setCellValue(e.getContractNumber());
            Cell cell12 = row1.createCell(2);
            cell12.setCellValue(e.getViolationState());
            Cell cell13 = row1.createCell(3);
            cell13.setCellValue(e.getPenalty());
            Cell cell14 = row1.createCell(4);
            cell14.setCellValue(e.getDetail());
            Cell cell15 = row1.createCell(5);
            cell15.setCellValue(e.getViolationLocation());
            Cell cell16 = row1.createCell(6);
            cell16.setCellValue(myUtil.dateToStr(e.getViolationTime()));
        }
    }
}
