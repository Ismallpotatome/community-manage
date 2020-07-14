package com.community.manage.mapper;

import com.community.manage.domain.entity.TbParkingDetail;

public interface TbParkingDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(TbParkingDetail record);

    int insertSelective(TbParkingDetail record);

    TbParkingDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(TbParkingDetail record);

    int updateByPrimaryKey(TbParkingDetail record);
}