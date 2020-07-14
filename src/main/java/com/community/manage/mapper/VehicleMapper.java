package com.community.manage.mapper;

import com.community.manage.domain.entity.Vehicle;

public interface VehicleMapper {
    int deleteByPrimaryKey(Integer vehicleId);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(Integer vehicleId);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
}