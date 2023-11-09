package com.gym.test.mapper;

import com.gym.test.pojo.DamageInformation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Mapper
public interface DamageInformationMapper {

    List<DamageInformation> getDamageInformations();

    @Insert("insert into damage_information values (null,#{orderId},#{contractNumber},null,#{returnImg.id},#{damageState},#{detail},0)")
    @Options(useGeneratedKeys = true,keyProperty = "damageInformationId",keyColumn = "damageInformationId")
    void addDamageInformation(DamageInformation damageInformation);

    @Update("update damage_information set isdelete=1 where contract_number=#{contractNumber}")
    void removeDamageInformation(String contractNumber);

    @Update("update damage_information set contract_number=#{contractNumber},damage_state=#{damageState},detail=#{detail},return_img=#{returnImg.id}" +
            " where order_id=#{orderId} ")
    void updateDamageInformation(DamageInformation damageInformation);

    List<DamageInformation> getSearchEmployees(DamageInformation damageInformation);

    @Update("update damage_information set contract_number=#{contractNumber} where order_id=#{orderId}")
    void updateByOrderId(@Param("orderId") Integer orderId,@Param("contractNumber") String contractNumber);
}
