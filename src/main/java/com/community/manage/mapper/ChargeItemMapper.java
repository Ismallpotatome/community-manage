package com.community.manage.mapper;

import com.community.manage.domain.entity.ChargeItem;

public interface ChargeItemMapper {
    int deleteByPrimaryKey(Integer chargeId);

    int insert(ChargeItem record);

    int insertSelective(ChargeItem record);

    ChargeItem selectByPrimaryKey(Integer chargeId);

    int updateByPrimaryKeySelective(ChargeItem record);

    int updateByPrimaryKey(ChargeItem record);
}