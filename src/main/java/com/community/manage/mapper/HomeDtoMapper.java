package com.community.manage.mapper;

import com.community.manage.domain.dto.HomeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeDtoMapper {
    //根据时间和房产名称模糊查询出想要的HomeDto
    List<HomeDto> selectByKeyword(@Param("homeDto") HomeDto homeDto);
    //查询出查询结果的总条数
    HomeDto selectHomeNumber(@Param("homeDto") HomeDto homeDto);
    //根据房产Id查询一条房产记录
    HomeDto selectOne(@Param("homeId") int homeId);
}
