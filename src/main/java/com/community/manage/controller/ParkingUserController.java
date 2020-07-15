package com.community.manage.controller;


import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.service.ParkingUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingUserController {
    @Resource
    ParkingUserService parkingUserService;


    @PostMapping("select")
    public List<TbParkingUser> selectAll(@RequestParam(value = "keyword") String keyword, String begin, String end, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<TbParkingUser> tbParkingUsers = parkingUserService.selectAll(keyword, begin, end, limit, offset);
        return tbParkingUsers;
    }

    //添加一条信息
    @PostMapping("insert")
    public int insert(@RequestBody ParkingUseDto parkingUseDto){
        Integer comId = parkingUseDto.getCommunityId();
        String userName = parkingUseDto.getUserName();
        String userNumber = parkingUseDto.getUserNumber();
        TbParkingUser parkingUser = new TbParkingUser();
        parkingUser.setCommunityId(comId);
        parkingUser.setUserNumber(userNumber);
        parkingUser.setUserName(userName);

        return parkingUserService.insert(parkingUser);
    }

    //修改一条信息
    @PostMapping("updateBid")
    public int updateById(@RequestBody ParkingUseDto parkingUseDto){
        Integer status = parkingUseDto.getUserStatus();
        Integer userId = parkingUseDto.getUserId();
        return  parkingUserService.updateById(status,userId);
    }

    //修改所有信息
    @PostMapping("updateAll")
    public int updateAll(@RequestBody ParkingUseDto parkingUseDto){

        Integer comId = parkingUseDto.getCommunityId();
        String userName = parkingUseDto.getUserName();
        Integer status = parkingUseDto.getUserStatus();
        Integer userId = parkingUseDto.getUserId();

        return parkingUserService.updateAll(comId, userName, status, userId);
    }

    //批量删除信息
    @PostMapping("del")
    public int delOne(@RequestBody List<ParkingUseDto> parkingUseDto){

        return parkingUserService.del(parkingUseDto);

    }

}
