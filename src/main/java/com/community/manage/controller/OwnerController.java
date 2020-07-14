package com.community.manage.controller;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("owner")
public class OwnerController {
    @Resource
    OwnerService ownerService;

    /**
     * 业主的人员信息关键字分页查询
     * @param searchDto:查询信息类
     * @return List<Owner>:"业主信息"集合
     */
    @PostMapping("personnel/search")
    public List<Owner> personnelSearch(@RequestBody SearchDto searchDto) {

        return null;
    }

    /**
     * 业主的车辆信息关键字分页
     * @param searchDto:搜索查询信息类
     * @return List<VehicleDto>:"车辆封装信息"集合
     */
    @PostMapping("vehicle/search")
    public List<VehicleDto> vehicleSearch(@RequestBody SearchDto searchDto) {
        return ownerService.vehicleSearchByPage(searchDto);
    }

    /**
     *
     * @param vehicleDto:车辆信息封装类
     */
    @PostMapping("vehicle/add")
    public void vehicleAdd(@RequestBody VehicleDto vehicleDto){
        ownerService.addVehicle(vehicleDto);
    }

    /**
     *
     * @param vehicleIdList:需要批量删除的车辆id集合
     */
    @PostMapping("vehicle/delete_batch")
    public void vehicleBatchDelete(@RequestBody List<Integer> vehicleIdList){
        ownerService.deleteBatchVehicle(vehicleIdList);
    }
}
