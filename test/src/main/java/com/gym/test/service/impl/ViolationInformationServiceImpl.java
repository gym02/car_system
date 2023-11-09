package com.gym.test.service.impl;

import com.gym.test.mapper.ViolationInformationMapper;
import com.gym.test.pojo.ViolationInformation;
import com.gym.test.service.ViolationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class ViolationInformationServiceImpl implements ViolationInformationService {
    @Autowired
    ViolationInformationMapper violationInformationMapper;
    @Override
    public List<ViolationInformation> getViolationInformations() {
        return violationInformationMapper.getViolationInformations();
    }

    @Override
    public void addViolationInformation(ViolationInformation violationInformation) {
        violationInformationMapper.addViolationInformation(violationInformation);
    }

    @Override
    public void removeViolationInformation(String contractNumber) {
        violationInformationMapper.removeViolationInformation(contractNumber);
    }

    @Override
    public void updateViolationInformation(ViolationInformation violationInformation) {
        violationInformationMapper.updateViolationInformation(violationInformation);
    }

    @Override
    public List<ViolationInformation> getSearchViolationInformations(ViolationInformation violationInformation) {
        return violationInformationMapper.getSearchViolationInformations(violationInformation);
    }

    @Override
    public void updateByOrderId(Integer orderId, String contractNumber) {
        violationInformationMapper.updateByOrderId(orderId,contractNumber);
    }
}
