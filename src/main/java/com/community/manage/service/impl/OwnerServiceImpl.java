package com.community.manage.service.impl;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.domain.entity.Vehicle;
import com.community.manage.mapper.owner.OwnerVehicleMapper;
import com.community.manage.service.OwnerService;
import com.community.manage.util.ResponseEntity;
import com.community.manage.util.ReturnState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    OwnerVehicleMapper ownerVehicleMapper;

    @Override
    public ResponseEntity personnelSearchByPage(SearchDto searchDto) {

        return null;
    }

    /**
     * 根据关键字和时间对车辆信息进行分页查询
     * @param searchDto:搜索的信息
     * @return List<VehicleDto>:查询到的"车辆"信息集合
     */
    @Override
    public ResponseEntity vehicleSearchByPage(SearchDto searchDto) {
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
        List<VehicleDto> vehicleDtos = ownerVehicleMapper.selectBySearchAndLimit(searchDto);
        ResponseEntity<List<VehicleDto>> success = ResponseEntity.success(vehicleDtos);
        return  success;
    }

    /**
     *
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
     *
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
     *
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
}
