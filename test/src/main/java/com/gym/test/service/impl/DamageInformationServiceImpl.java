package com.gym.test.service.impl;

import com.gym.test.mapper.DamageInformationMapper;
import com.gym.test.pojo.DamageInformation;
import com.gym.test.service.DamageInformationService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class DamageInformationServiceImpl implements DamageInformationService {
    @Autowired
    DamageInformationMapper damageInformationMapper;
    @Override
    public List<DamageInformation> getDamageInformations() {
        return damageInformationMapper.getDamageInformations();
    }

    @Override
    public void addDamageInformation(DamageInformation damageInformation) {
        damageInformationMapper.addDamageInformation(damageInformation);
    }

    @Override
    public void removeDamageInformation(String contractNumber) {
        damageInformationMapper.removeDamageInformation(contractNumber);
    }

    @Override
    public void updateDamageInformation(DamageInformation damageInformation) {
        damageInformationMapper.updateDamageInformation(damageInformation);
    }

    @Override
    public List<DamageInformation> getSearchDamageInformations(DamageInformation damageInformation) {
        return damageInformationMapper.getSearchEmployees(damageInformation);
    }

    @Override
    public void updateByOrderId(Integer orderId, String contractNumber) {
        damageInformationMapper.updateByOrderId(orderId,contractNumber);
    }
}
