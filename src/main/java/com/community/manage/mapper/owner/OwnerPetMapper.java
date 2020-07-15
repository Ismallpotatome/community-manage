package com.community.manage.mapper.owner;

import com.community.manage.domain.dto.PetDto;
import com.community.manage.domain.dto.SearchDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerPetMapper {
    //根据关键字和时间进行分页查询
    List<PetDto> selectBySearchAndLimit(@Param("searchDto") SearchDto searchDto);
}
