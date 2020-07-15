package com.community.manage.mapper;

import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.domain.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunityDtoMapper {
    //根据时间和名字选择过滤出每条小区总户数
    CommunityDto selectSum(@Param("communityDto") CommunityDto communityDto);
    //根据根据时间和名字选择过滤出想要的小区信息集合
    List<CommunityDto> selectFilter(@Param("communityDto") CommunityDto communityDto);
    //根据
}
