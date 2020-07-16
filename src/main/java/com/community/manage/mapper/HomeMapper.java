package com.community.manage.mapper;

import com.community.manage.domain.entity.Build;
import com.community.manage.domain.entity.Home;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeMapper {
    int deleteByPrimaryKey(Integer homeId);

    int insert(Home record);

    int insertSelective(Home record);

    Home selectByPrimaryKey(Integer homeId);

    int updateByPrimaryKeySelective(Home record);

    int updateByPrimaryKey(Home record);
    //根据一条栋数Id查询全部房产
    List<Home> selectByBuildId(int buildId);
    //根据栋数集合查询全部房产
    List<Home> selectAllHome(@Param("builds")List<Build> builds);
    //根据一条房产Id查询房产
    Home selectOne(@Param("homeId") int homeId);
    //根据一条房产Id删除房产
    int deleteOne(@Param("homeId") int homeId);
    //根据房产集合批量删除房产
    int deleteBatch(@Param("homes") List<Home> homes);
    //插入一条home数据记录
    int insertOne(@Param("home") Home home);
    //修改一条记录
    int updateOne(@Param("home") Home home);
}