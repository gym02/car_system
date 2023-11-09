package com.gym.test.service;

import com.gym.test.pojo.DamageInformation;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface DamageInformationService {
    List<DamageInformation> getDamageInformations();

    void addDamageInformation(DamageInformation damageInformation);

    void removeDamageInformation(String contractNumber);

    void updateDamageInformation(DamageInformation damageInformation);

    List<DamageInformation> getSearchDamageInformations(DamageInformation damageInformation);

    void updateByOrderId(Integer orderId, String contractNumber);
}
