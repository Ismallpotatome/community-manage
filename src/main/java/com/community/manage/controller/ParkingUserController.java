package com.community.manage.controller;


import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.service.ParkingUserService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingUserController {
    @Resource
    ParkingUserService parkingUserService;


    @PostMapping("select")
    public ResponseEntity<List<TbParkingUser>> selectAll(@RequestBody SearchsDto searchsDto,@RequestParam(defaultValue = "1") int limit,@RequestParam(defaultValue = "10") int offset){

        List<TbParkingUser> tbParkingUsers = parkingUserService.selectAll(searchsDto,limit, offset);
        return ResponseEntity.success(tbParkingUsers);
    }

    //添加一条信息
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ParkingUseDto parkingUseDto){
        ResponseEntity responseEntity = parkingUserService.insert(parkingUseDto);

        return responseEntity;
    }

    //修改一条信息
    @PostMapping("updateBid")
    public ResponseEntity updateById(@RequestBody ParkingUseDto parkingUseDto){
        Integer status = parkingUseDto.getUserStatus();
        Integer userId = parkingUseDto.getUserId();
        ResponseEntity responseEntity = parkingUserService.updateById(status, userId);
        return  responseEntity;
    }

    //修改所有信息
    @PostMapping("updateAll")
    public ResponseEntity updateAll(@RequestBody ParkingUseDto parkingUseDto){

        ResponseEntity responseEntity = parkingUserService.updateAll(parkingUseDto);

        return responseEntity ;
    }

    //批量删除信息
    @PostMapping("del")
    public ResponseEntity  delOne(@RequestBody List<ParkingUseDto> parkingUseDto){
        ResponseEntity del = parkingUserService.del(parkingUseDto);
        return del;

    }

}
