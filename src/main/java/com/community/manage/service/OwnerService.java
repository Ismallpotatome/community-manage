package com.community.manage.service;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.domain.entity.Vehicle;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface OwnerService {
    //业主人员信息的关键字分页查询
    ResponseEntity personnelSearchByPage(SearchDto searchDto);
    //通过小区id查询业主的名称和id
    ResponseEntity personnelByCommunityId(Integer communityId);

    //业主车辆信息的关键字分页查询
    ResponseEntity vehicleSearchByPage(SearchDto searchDto);
    //添加"车辆"
    ResponseEntity addVehicle(VehicleDto vehicleDto);
    //批量删除"车辆"
    ResponseEntity deleteBatchVehicle(List<Integer> vehicleIdList);
    //删除单个"车辆"
    ResponseEntity deleteSingleVehicle(Integer vehicleId);
    //修改"车辆"信息
    ResponseEntity vehicleAlter(VehicleDto vehicleDto);

    //业主车辆信息的关键字分页查询
    ResponseEntity petSearchByPage(SearchDto searchDto);
}
