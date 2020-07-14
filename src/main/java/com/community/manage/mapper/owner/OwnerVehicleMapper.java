package com.community.manage.mapper.owner;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerVehicleMapper {

    //根据关键字和时间进行分页查询
    List<VehicleDto> selectBySearchAndLimit(@Param("searchDto")SearchDto searchDto);

}
