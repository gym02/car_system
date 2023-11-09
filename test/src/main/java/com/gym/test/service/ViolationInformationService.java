package com.gym.test.service;

import com.gym.test.pojo.ViolationInformation;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface ViolationInformationService {
    List<ViolationInformation> getViolationInformations();

    void addViolationInformation(ViolationInformation violationInformation);

    void removeViolationInformation(String contractNumber);

    void updateViolationInformation(ViolationInformation violationInformation);

    List<ViolationInformation> getSearchViolationInformations(ViolationInformation violationInformation);

    void updateByOrderId(Integer orderId, String contractNumber);
}
