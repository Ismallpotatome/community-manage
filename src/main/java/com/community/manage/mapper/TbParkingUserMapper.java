package com.community.manage.mapper;

import com.community.manage.domain.entity.TbParkingUser;

public interface TbParkingUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TbParkingUser record);

    int insertSelective(TbParkingUser record);

    TbParkingUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TbParkingUser record);

    int updateByPrimaryKey(TbParkingUser record);
}