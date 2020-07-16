package com.community.manage.mapper;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.dto.HomeDto;
import com.community.manage.domain.entity.Build;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildDtoMapper {
    //获取查询出来的数据总条数
    BuildDto selectMsgNumber(@Param("buildDto") BuildDto buildDto);
    //根据传进来的startDate,endDate,buildName,page,size来选择出想要的build字段
    List<BuildDto> selectByKeyword(@Param("buildDto") BuildDto buildDto);
    //根据一个栋数Id查询一条栋数记录
    BuildDto selectOne(@Param("buildId") int buildId);
    //根据一个小区Id查询所有的栋数
    List<BuildDto> selectAllBuildDto(@Param("communityId") int communityId);
}
