package com.community.manage.mapper.owner;

import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerVehicleMapper {

    //根据关键字和时间进行分页查询
    List<VehicleDto> selectBySearchAndLimit(@Param("searchDto") SearchsDto searchDto);
    //插入"车辆"
    int insertVehicleDto(@Param("vehicle") Vehicle vehicle);
    //根据id批量修改数据状态
    int updateBatchVehicle(@Param("vehicleIdList") List<Integer> vehicleIdList);
    //根据id单个修改数据状态
    int updateSingleVehicle(@Param("vehicleId") Integer vehicleId);
    //修改信息
    int updateVehicle(@Param("vehicle") Vehicle vehicle);
}
