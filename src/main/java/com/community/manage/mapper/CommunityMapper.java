package com.community.manage.mapper;

import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.domain.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunityMapper {
    int deleteByPrimaryKey(Integer communityId);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(Integer communityId);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);

    //根据时间和名字选择过滤出想要的小区
    List<Community> selectFilter(@Param("startDate") String  startDate,
                                    @Param("endDate") String endDate,
                                    @Param("limit") int limit ,
                                    @Param("offset") int offset);

    //删除一条数据
    int deleteOne(@Param("communityId") int communityId);
    //删除多条数据
    int deleteBatch(@Param("communities") List<Community> communities);
    //更新一条数据
    int updateOne(@Param("community") Community community);
    //插入一条数据
    int insertOne(@Param("community") Community community);
}