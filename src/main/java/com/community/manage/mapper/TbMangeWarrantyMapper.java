package com.community.manage.mapper;

import com.community.manage.domain.entity.TbMangeWarranty;

public interface TbMangeWarrantyMapper {
    int deleteByPrimaryKey(Integer warrantyId);

    int insert(TbMangeWarranty record);

    int insertSelective(TbMangeWarranty record);

    TbMangeWarranty selectByPrimaryKey(Integer warrantyId);

    int updateByPrimaryKeySelective(TbMangeWarranty record);

    int updateByPrimaryKey(TbMangeWarranty record);
}