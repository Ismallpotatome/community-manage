package com.community.manage.service;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.domain.entity.Vehicle;

import java.util.List;

public interface OwnerService {
    //业主人员信息的关键字分页查询
    List<Owner> personnelSearchByPage(SearchDto searchDto);
    //业主车辆信息的关键字分页查询
    List<VehicleDto> vehicleSearchByPage(SearchDto searchDto);
    //添加"车辆"
    void addVehicle(VehicleDto vehicleDto);
    //批量删除"车辆"
    void deleteBatchVehicle(List<Integer> vehicleIdList);
}
