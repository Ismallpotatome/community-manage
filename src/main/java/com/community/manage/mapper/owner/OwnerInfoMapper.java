package com.community.manage.mapper.owner;

import com.community.manage.domain.dto.OwnerDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerInfoMapper {
    //根据小区id查询业主的名称和id
    List<OwnerDto> selectByCommunityId(@Param("communityId") Integer communityId);
}
