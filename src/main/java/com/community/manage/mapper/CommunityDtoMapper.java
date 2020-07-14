package com.community.manage.mapper;

import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.domain.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunityDtoMapper {
    //根据时间和名字选择过滤出想要的小区
    List<CommunityDto> selectSum(@Param("startDate") String  startDate,
                                 @Param("endDate") String endDate,
                                 @Param("limit") int limit,
                                 @Param("offset") int offset);
}
