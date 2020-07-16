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
//    List<Community> selectFilter(@Param("startDate") String  startDate,
//                                    @Param("endDate") String endDate,
//                                    @Param("limit") int limit ,
//                                    @Param("offset") int offset);

    //删除一条数据
    int deleteOne(@Param("communityId") int communityId);
    //删除多条数据
    int deleteBatch(@Param("communities") List<Community> communities);
    //更新一条数据
    int updateOne(@Param("community") Community community);
    //插入一条数据
    int insertOne(@Param("community") Community community);
    //修改status状态
    int updateStatus(@Param("communityId") int communityId, @Param("status") int status);
    //根据小区Id筛选出一条小区信息
    Community selectOneCommunity(@Param("communityId") int communityId);
    //查询所以小区的信息包含名字和id
    List<Community> selectAllCommunity();
    //根据小区名字获取一条小区信息
    Community selectCommunityByName(@Param("communityName") String communityName);
}