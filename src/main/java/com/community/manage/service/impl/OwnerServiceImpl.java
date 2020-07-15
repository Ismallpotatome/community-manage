package com.community.manage.service.impl;

import com.community.manage.domain.dto.OwnerDto;
import com.community.manage.domain.dto.PetDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Pet;
import com.community.manage.domain.entity.Vehicle;
import com.community.manage.mapper.owner.OwnerInfoMapper;
import com.community.manage.mapper.owner.OwnerPetMapper;
import com.community.manage.mapper.owner.OwnerVehicleMapper;
import com.community.manage.service.OwnerService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    OwnerVehicleMapper ownerVehicleMapper;
    @Resource
    OwnerInfoMapper ownerInfoMapper;
    @Resource
    OwnerPetMapper ownerPetMapper;

    /**
     * 分页处理
     * @return
     */
    public void pageDispose(SearchDto searchDto){
        //检测page是否为空
        if(searchDto.getPage() == 0 ){
            searchDto.setPage(1);
        }
        //检测size是否为空
        if(searchDto.getSize() == 0){
            searchDto.setSize(5);
        }
        //查询的起始
        int limit = (searchDto.getPage() - 1) * searchDto.getSize();
        searchDto.setPage(limit);
    }
    @Override
    public ResponseEntity personnelSearchByPage(SearchDto searchDto) {

        return null;
    }

    /**
     * 根据小区id查询业主的名称和id
     * @param communityId:需要查询的小区id
     * @return
     */
    @Override
    public ResponseEntity personnelByCommunityId(Integer communityId) {
        //数据访问
        List<OwnerDto> ownerDtos = ownerInfoMapper.selectByCommunityId(communityId);
        //对访问到的数据结果进行处理并返回
        return ResponseEntity.success(ownerDtos);
    }

    /**
     * 根据关键字和时间对车辆信息进行分页查询
     * @param searchDto:搜索的信息
     * @return List<VehicleDto>:查询到的"车辆"信息集合
     */
    @Override
    public ResponseEntity vehicleSearchByPage(SearchDto searchDto) {
        //分页处理
        pageDispose(searchDto);
        //数据访问
        List<VehicleDto> vehicleDtos = ownerVehicleMapper.selectBySearchAndLimit(searchDto);
        return  ResponseEntity.success(vehicleDtos);
    }

    /**
     *添加车辆
     * @param vehicleDto:添加的车辆信息封装类
     */
    @Override
    public ResponseEntity addVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        //将封装类对象的数据赋值给对应的实体类对象
        BeanUtils.copyProperties(vehicleDto,vehicle);
        int i = ownerVehicleMapper.insertVehicleDto(vehicle);
        //返回的结果处理
        if(i > 0){
            //添加成功
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error();
        }
    }

    /**
     *批量删除车辆
     * @param vehicleIdList:批量删除的车辆id集合
     */
    @Override
    public ResponseEntity deleteBatchVehicle(List<Integer> vehicleIdList) {
        int i = ownerVehicleMapper.updateBatchVehicle(vehicleIdList);
        //返回的结果处理
        if(i > 0){
            //添加成功
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error();
        }
    }

    /**
     *删除单个车辆
     * @param vehicleId:需要删除的车辆id
     */
    @Override
    public ResponseEntity deleteSingleVehicle(Integer vehicleId) {
        int i = ownerVehicleMapper.updateSingleVehicle(vehicleId);
        //数据操作结果处理
        //返回的结果处理
        if(i > 0){
            //添加成功
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error();
        }
    }

    /**
     * 修改车辆信息
     * @param vehicleDto:封装的"车辆"信息
     * @return
     */
    @Override
    public ResponseEntity vehicleAlter(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleDto,vehicle);
        int i = ownerVehicleMapper.updateVehicle(vehicle);
        if(i > 0){
            return ResponseEntity.success();
        }else {
            return ResponseEntity.error();
        }
    }

    /**
     * 根据关键字和时间对宠物信息进行分页查询
     * @param searchDto 封装的搜索信息
     * @return
     */
    @Override
    public ResponseEntity petSearchByPage(SearchDto searchDto) {
        //分页处理
        pageDispose(searchDto);
        //数据访问
        List<PetDto> petDtos = ownerPetMapper.selectBySearchAndLimit(searchDto);
        return ResponseEntity.success(petDtos);
    }

    /**
     * 添加"宠物"
     * @param petDto:封装的"宠物"信息
     * @return
     */
    @Override
    public ResponseEntity addPet(PetDto petDto) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto,pet);
        int i = ownerPetMapper.insertPet(pet);
        if(i > 0){
            return ResponseEntity.success();
        }else {
            return ResponseEntity.error();
        }
    }

    /**
     * 批量删除宠物
     * @param vehicleIdList:宠物id集合
     * @return
     */
    @Override
    public ResponseEntity deleteBatchPet(List<Integer> vehicleIdList) {
        int i = ownerPetMapper.updateBatchPet(vehicleIdList);
        if(i > 0){
            return ResponseEntity.success();
        }else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"宠物"信息
     * @param petDto:封装的宠物信息类
     * @return
     */
    @Override
    public ResponseEntity petAlter(PetDto petDto) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto,pet);
        int i = ownerPetMapper.updatePet(pet);
        if(i > 0){
            return ResponseEntity.success();
        }else {
            return ResponseEntity.error();
        }
    }
}
