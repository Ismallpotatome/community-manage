package com.community.manage.mapper;

import com.community.manage.domain.entity.TbMangeMail;

public interface TbMangeMailMapper {
    int deleteByPrimaryKey(Integer mailId);

    int insert(TbMangeMail record);

    int insertSelective(TbMangeMail record);

    TbMangeMail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(TbMangeMail record);

    int updateByPrimaryKey(TbMangeMail record);
}