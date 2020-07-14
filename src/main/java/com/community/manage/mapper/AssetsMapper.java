package com.community.manage.mapper;

import com.community.manage.domain.dto.AssetsSearchDto;
import com.community.manage.domain.entity.Assets;
import com.community.manage.domain.vo.AssetsBean;
import org.apache.ibatis.annotations.Param;

public interface AssetsMapper {
    int deleteByPrimaryKey(Integer assetsId);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer assetsId);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKey(Assets record);

    AssetsBean selectAll();

    AssetsBean selectByKey(@Param("assetsSearchDto") AssetsSearchDto assetsSearchDto);
}