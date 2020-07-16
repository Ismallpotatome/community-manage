package com.community.manage.mapper;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.entity.Build;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildMapper {
    int deleteByPrimaryKey(Integer buildId);

    int insert(Build record);

    int insertSelective(Build record);

    Build selectByPrimaryKey(Integer buildId);

    int updateByPrimaryKeySelective(Build record);

    int updateByPrimaryKey(Build record);

    //根据小区Id查询所有栋数
    List<Build> selectAllBuildByCommunityId(@Param("communityId") int communityId);
    //根据小区Id删除所有的栋数
    int deleteAllBuild(@Param("builds") List<Build> builds);
    //根据栋数Id铲除一条数据
    int deleteOne(@Param("buildId") int buildId);
    //根据栋数Id修改一条数据
    int updateOne(@Param("build") Build build);
    //添加一条信息
    int insertOne(@Param("build") Build build);



}