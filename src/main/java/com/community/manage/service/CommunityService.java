package com.community.manage.service;

import com.community.manage.domain.dto.CommunityDto;

import java.util.List;

public interface CommunityService {
    //按关键字段查询
    List<CommunityDto> selectByFilter(CommunityDto filter);
    //删除一条数据
    String deleteOne(int communityId);
    //批量删除数据
    String deleteBatch(List<CommunityDto> communityDtos);
    //跟新一条数据
    String updateOne(CommunityDto communityDto);
    //插入一条数据
    String insertOne(CommunityDto communityDto);
}
