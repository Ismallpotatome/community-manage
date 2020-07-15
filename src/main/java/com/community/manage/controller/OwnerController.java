package com.community.manage.controller;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.service.OwnerService;
import com.community.manage.util.ResponseEntity;
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
    public ResponseEntity personnelSearch(@RequestBody SearchDto searchDto) {

        return null;
    }

    /**
     * 通过小区id查询业主的名称和id
     * @param communityId
     * @return
     */
    @PostMapping("personnel/select_by_community")
    public ResponseEntity personnelByCommunityId(@RequestBody Integer communityId){
        return ownerService.personnelByCommunityId(communityId);
    }


    //业主的车辆信息

    /**
     * 业主的车辆信息关键字分页
     * @param searchDto:搜索查询信息类
     * @return List<VehicleDto>:"车辆封装信息"集合
     */
    @PostMapping("vehicle/search")
    public ResponseEntity vehicleSearch(@RequestBody SearchDto searchDto) {
        return ownerService.vehicleSearchByPage(searchDto);
    }

    /**
     * 业主的车辆添加
     * @param vehicleDto:车辆信息封装类
     */
    @PostMapping("vehicle/add")
    public ResponseEntity vehicleAdd(@RequestBody VehicleDto vehicleDto){

        return ownerService.addVehicle(vehicleDto);
    }


    /**
     *批量删除车辆
     * @param vehicleIdList:需要批量删除的车辆id集合
     */
    @PostMapping("vehicle/delete_batch")
    public ResponseEntity vehicleBatchDelete(@RequestBody List<Integer> vehicleIdList){
        return ownerService.deleteBatchVehicle(vehicleIdList);
    }

    /**
     *删除单个车辆
     * @param vehicleId:需要删除的车辆id
     */
    @PostMapping("vehicle/delete_single")
    public ResponseEntity vehicleSingleDelete(@RequestBody Integer vehicleId){
        return ownerService.deleteSingleVehicle(vehicleId);
    }

    /**
     * 修改车辆信息
     * @param vehicleDto:车辆信息的封装类
     * @return
     */
    @PostMapping("vehicle/alter")
    public ResponseEntity vehicleAlter(@RequestBody VehicleDto vehicleDto){
        return ownerService.vehicleAlter(vehicleDto);
    }

    //业主宠物信息
    @PostMapping("pet/search")
    public ResponseEntity petSearch(@RequestBody SearchDto searchDto) {
        return ownerService.petSearchByPage(searchDto);
    }
}
