package com.community.manage.mapper;

import com.community.manage.domain.entity.Assets;

public interface AssetsMapper {
    int deleteByPrimaryKey(Integer assetsId);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer assetsId);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKey(Assets record);
}