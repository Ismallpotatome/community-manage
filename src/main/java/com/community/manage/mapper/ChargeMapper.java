package com.community.manage.mapper;

import com.community.manage.domain.entity.Charge;

public interface ChargeMapper {
    int deleteByPrimaryKey(Integer chargeId);

    int insert(Charge record);

    int insertSelective(Charge record);

    Charge selectByPrimaryKey(Integer chargeId);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);
}