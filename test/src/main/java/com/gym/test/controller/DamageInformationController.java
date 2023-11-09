package com.gym.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.test.pojo.Car;
import com.gym.test.pojo.DamageInformation;
import com.gym.test.pojo.dto.CarExportDto;
import com.gym.test.pojo.dto.DamageInformationExportDto;
import com.gym.test.pojo.dto.DamageInformationPageDto;
import com.gym.test.service.DamageInformationService;
import com.gym.test.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Controller
@RequestMapping("/damageInformation")
public class DamageInformationController {
    @Autowired
    DamageInformationService damageInformationService;

    //    ===================================================================================增删改
    //获得所有损坏信息
    @ResponseBody
    @PostMapping("/getDamageInformations")
    public Object getdamageInformations(@RequestBody DamageInformationPageDto damageInformationPageDto) {
        PageHelper.startPage(damageInformationPageDto.getPageNum(), damageInformationPageDto.getPageSize());
        List<DamageInformation> damageInformations = damageInformationService.getDamageInformations();
        PageInfo pageInfo = new PageInfo(damageInformations);
        return new ResponseEntity(200, "所有损坏信息", pageInfo);
    }

    //添加损坏信息
    @ResponseBody
    @PostMapping("/addDamageInformation")
    public Object addDamageInformation(@RequestBody DamageInformation damageInformation) {
        damageInformationService.addDamageInformation(damageInformation);
        return new ResponseEntity(200, "添加成功", damageInformation);
    }

    //删除损坏信息
    @ResponseBody
    @PostMapping("/removeDamageInformation/{contractNumber}")
    public Object removeDamageInformation(@PathVariable String contractNumber) {
        damageInformationService.removeDamageInformation(contractNumber);
        return new ResponseEntity(200, "删除成功", null);
    }

    //修改损坏信息
    @ResponseBody
    @PostMapping("/updateDamageInformation")
    public Object updateDamageInformation(@RequestBody DamageInformation damageInformation) {
        damageInformationService.updateDamageInformation(damageInformation);
        return new ResponseEntity(200, "修改成功", damageInformation);
    }

    //根据orderId修改订单号
    @ResponseBody
    @PostMapping("/updateByOrderId")
    public Object updateByOrderId(@RequestBody DamageInformation damageInformation) {
        damageInformationService.updateByOrderId(damageInformation.getOrderId(),damageInformation.getContractNumber());
        return new ResponseEntity(200, "修改成功", null);
    }

    //=========================================================================搜索
    //根据搜索查询破损信息
    @ResponseBody
    @PostMapping("/getSearchDamageInformations")
    public Object getSearchDamageInformations(@RequestBody DamageInformation damageInformation) {
        List<DamageInformation> damageInformations = damageInformationService.getSearchDamageInformations(damageInformation);
        return new ResponseEntity(200, "搜索到的汽车破损信息", damageInformations);
    }

    // ===========================================================================================导出
//  根据搜索条件导出excel表格
    @GetMapping("/export")
    public Object export(DamageInformationExportDto damageInformationExportDto, Map map) throws IOException {
        PageHelper.startPage(damageInformationExportDto.getPageNum(), damageInformationExportDto.getPageSize());
        DamageInformation damageInformation = new DamageInformation(damageInformationExportDto.getDamageInformationId(),
                null, damageInformationExportDto.getContractNumber(), null, null, damageInformationExportDto.getDamageState(),
                damageInformationExportDto.getDetail(), 0);
        List<DamageInformation> damageInformations = damageInformationService.getSearchDamageInformations(damageInformation);
        map.put("damageInformations", damageInformations);
        return "damageInformationExport";
    }
}
