package com.community.manage.mapper;

import com.community.manage.domain.entity.TbMangeActivity;

public interface TbMangeActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(TbMangeActivity record);

    int insertSelective(TbMangeActivity record);

    TbMangeActivity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(TbMangeActivity record);

    int updateByPrimaryKey(TbMangeActivity record);
}