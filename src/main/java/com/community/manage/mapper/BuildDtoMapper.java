package com.community.manage.mapper;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.entity.Build;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildDtoMapper {
    //获取built数据总条数
    BuildDto selectMsgNumber(@Param("buildDto") BuildDto buildDto);
    //根据传进来的startDate,endDate,buildName,page,size来选择出想要的build字段
    List<BuildDto> selectByKeyword(@Param("buildDto") BuildDto buildDto);
}
