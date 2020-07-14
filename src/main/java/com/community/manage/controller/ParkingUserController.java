package com.community.manage.controller;


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
    public int insert(int comId,String usernumber,String username){
        TbParkingUser parkingUser = new TbParkingUser();
        parkingUser.setUserCommunity(comId);
        parkingUser.setUserNumber(usernumber);
        parkingUser.setUserName(username);

        return parkingUserService.insert(parkingUser);
    }

    //修改一条信息
    @PostMapping("updateBid")
    public int updateById(int status,int id){
        return  parkingUserService.updateById(status,id);
    }

    //修改所有信息
    @PostMapping("updateAll")
    public int updateAll(int comId,String username,int status,int userId){
        return parkingUserService.updateAll(comId, username, status, userId);
    }

    //删除一条信息
    @PostMapping("del")
    public int delOne(List<Integer> list){
        return parkingUserService.del(list);
    }

}
