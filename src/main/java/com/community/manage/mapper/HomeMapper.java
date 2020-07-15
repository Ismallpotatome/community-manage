package com.community.manage.mapper;

import com.community.manage.domain.entity.Home;

import java.util.List;

public interface HomeMapper {
    int deleteByPrimaryKey(Integer homeId);

    int insert(Home record);

    int insertSelective(Home record);

    Home selectByPrimaryKey(Integer homeId);

    int updateByPrimaryKeySelective(Home record);

    int updateByPrimaryKey(Home record);
    //根据栋数Id查询全部房产
    List<Home> selectByBuildId(int buildId);
}