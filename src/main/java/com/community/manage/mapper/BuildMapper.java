package com.community.manage.mapper;

import com.community.manage.domain.entity.Build;

public interface BuildMapper {
    int deleteByPrimaryKey(Integer buildId);

    int insert(Build record);

    int insertSelective(Build record);

    Build selectByPrimaryKey(Integer buildId);

    int updateByPrimaryKeySelective(Build record);

    int updateByPrimaryKey(Build record);


}