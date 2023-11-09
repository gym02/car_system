package com.gym.test.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.test.pojo.DamageInformation;
import com.gym.test.pojo.User;
import com.gym.test.pojo.ViolationInformation;
import com.gym.test.pojo.dto.DamageInformationExportDto;
import com.gym.test.pojo.dto.ViolationInformationExportDto;
import com.gym.test.pojo.dto.ViolationInformationPageDto;
import com.gym.test.service.ViolationInformationService;
import com.gym.test.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Controller
@RequestMapping("/violationInformation")
public class ViolationInformationController {
    @Autowired
    ViolationInformationService violationInformationService;

    //   =========================================================================增删改
    //获得所有违章信息
    @ResponseBody
    @PostMapping("/getViolationInformations")
    public Object getViolationInformations(@RequestBody ViolationInformationPageDto violationInformationPageDto) {
        PageHelper.startPage(violationInformationPageDto.getPageNum(), violationInformationPageDto.getPageSize());
        List<ViolationInformation> violationInformations = violationInformationService.getViolationInformations();
        PageInfo pageInfo = new PageInfo(violationInformations);
        return new ResponseEntity(200, "所有违章信息", pageInfo);
    }

    //添加违章信息
    @ResponseBody
    @PostMapping("/addViolationInformation")
    public Object addViolationInformation(@RequestBody ViolationInformation violationInformation) {
        violationInformationService.addViolationInformation(violationInformation);
        return new ResponseEntity(200, "添加成功", violationInformation);
    }

    //删除违章信息
    @ResponseBody
    @PostMapping("/removeViolationInformation/{contractNumber}")
    public Object removeViolationInformation(@PathVariable String contractNumber) {
        violationInformationService.removeViolationInformation(contractNumber);
        return new ResponseEntity(200, "删除成功", null);
    }

    //修改违章信息
    @ResponseBody
    @PostMapping("/updateViolationInformation")
    public Object updateViolationInformation(@RequestBody ViolationInformation violationInformation) {
        violationInformationService.updateViolationInformation(violationInformation);
        return new ResponseEntity(200, "修改成功", violationInformation);
    }

    //根据orderId修改订单号
    @ResponseBody
    @PostMapping("/updateByOrderId")
    public Object updateByOrderId(@RequestBody ViolationInformation violationInformation) {
        violationInformationService.updateByOrderId(violationInformation.getOrderId(),violationInformation.getContractNumber());
        return new ResponseEntity(200, "修改成功", null);
    }

    //  ===============================================================================搜索
    //根据搜索信息查询违章信息
    @ResponseBody
    @PostMapping("/getSearchViolationInformations")
    public Object getSearchViolationInformations(@RequestBody ViolationInformation violationInformation) {
        List<ViolationInformation> violationInformations = violationInformationService.getSearchViolationInformations(violationInformation);
        return new ResponseEntity(200, "搜索到的违章信息", violationInformations);
    }

    // ===========================================================================================导出
//  根据搜索条件导出excel表格
    @GetMapping("/export")
    public Object export(ViolationInformationExportDto violationInformationExportDto, Map map) throws IOException {
        PageHelper.startPage(violationInformationExportDto.getPageNum(), violationInformationExportDto.getPageSize());
        ViolationInformation violationInformation = new ViolationInformation(violationInformationExportDto.getViolationInformationId(),
                null, violationInformationExportDto.getContractNumber(), violationInformationExportDto.getViolationState(),
                violationInformationExportDto.getPenalty(), violationInformationExportDto.getDetail(),
                violationInformationExportDto.getViolationLocation(), violationInformationExportDto.getViolationTime(), 0);
        List<ViolationInformation> violationInformations = violationInformationService.getSearchViolationInformations(violationInformation);
        map.put("violationInformations", violationInformations);
        return "violationInformationExport";
    }
}
