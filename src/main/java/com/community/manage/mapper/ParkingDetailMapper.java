package com.community.manage.mapper;

import com.community.manage.domain.entity.ParkingDetail;

public interface ParkingDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(ParkingDetail record);

    int insertSelective(ParkingDetail record);

    ParkingDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(ParkingDetail record);

    int updateByPrimaryKey(ParkingDetail record);
}