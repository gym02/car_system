package com.gym.test.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.test.pojo.ViolationInformation;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface ViolationInformationMapper {
    @Select("select * from violation_information where isdelete=0")
    List<ViolationInformation> getViolationInformations();
    @Insert("insert into violation_information values (null,#{orderId},#{contractNumber},#{violationState},#{penalty}," +
            "#{detail},#{violationLocation},#{violationTime},0)")
    @Options(useGeneratedKeys = true,keyProperty = "violationInformationId",keyColumn = "violationInformationId")
    void addViolationInformation(ViolationInformation violationInformation);

    @Update("update violation_information set isdelete=1 where contract_number=#{contractNumber}")
    void removeViolationInformation(String contractNumber);

    @Update("update violation_information set contract_number=#{contractNumber},violation_state=#{violationState}," +
            "penalty=#{penalty}, detail=#{detail},violation_location=#{violationLocation},violation_time=#{violationTime}" +
            " where order_id=#{orderId}")
    void updateViolationInformation(ViolationInformation violationInformation);

    List<ViolationInformation> getSearchViolationInformations(ViolationInformation violationInformation);

    @Update("update violation_information set contract_number=#{contractNumber} where order_id=#{orderId}")
    void updateByOrderId(@Param("orderId") Integer orderId,@Param("contractNumber") String contractNumber);
}
