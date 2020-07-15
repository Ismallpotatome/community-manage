package com.community.manage.service;

import com.community.manage.domain.dto.OwnerDto;
import com.community.manage.domain.dto.PetDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface OwnerService {
    //业主人员信息的关键字分页查询
    ResponseEntity personnelSearchByPage(SearchsDto searchDto);
    //添加"业主"
    ResponseEntity addPersonnel(OwnerDto ownerDto);
    //批量删除"业主"
    ResponseEntity deleteBatchPersonnel(List<Integer> personnelIdList);
    //修改"业主"信息
    ResponseEntity personnelAlter(OwnerDto ownerDto);
    //删除单个"业主"
    ResponseEntity deleteSinglePersonnel(Integer personneId);
    //通过小区id查询业主的名称和id
    ResponseEntity personnelByCommunityId(Integer communityId);

    //业主车辆信息的关键字分页查询
    ResponseEntity vehicleSearchByPage(SearchsDto searchDto);
    //添加"车辆"
    ResponseEntity addVehicle(VehicleDto vehicleDto);
    //批量删除"车辆"
    ResponseEntity deleteBatchVehicle(List<Integer> vehicleIdList);
    //删除单个"车辆"
    ResponseEntity deleteSingleVehicle(Integer vehicleId);
    //修改"车辆"信息
    ResponseEntity vehicleAlter(VehicleDto vehicleDto);

    //业主宠物信息的关键字分页查询
    ResponseEntity petSearchByPage(SearchsDto searchDto);
    //添加宠物
    ResponseEntity addPet(PetDto petDto);
    //批量删除"宠物"
    ResponseEntity deleteBatchPet(List<Integer> vehicleIdList);
    //修改"宠物"信息
    ResponseEntity petAlter(PetDto petDto);
    //删除单个"宠物"
    ResponseEntity deleteSinglePet(Integer petId);
}
