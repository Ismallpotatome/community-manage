package com.community.manage.controller;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.service.ParkingDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("detail")
public class ParkingDetailController {

    @Resource
    ParkingDetailService parkingDetailService;


    @PostMapping("select")
    public List<TbParkingDetail> selectAll(@RequestParam(value = "keyword") String keyword, String begin, String end, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<TbParkingDetail> tbParkingDetails = parkingDetailService.selectAll(keyword, begin, end, limit, offset);
        return tbParkingDetails;
    }


    //添加一条信息
    @PostMapping("insert")
    public int insert(@RequestBody ParkingDetailDto parkingDetailDto){


        return parkingDetailService.insert(parkingDetailDto);
    }

    //修改所有信息
    @PostMapping("updateAll")
    public int updateAll(@RequestBody ParkingDetailDto parkingDetailDto){



        return parkingDetailService.updateAll(parkingDetailDto);
    }

    //批量删除信息
    @PostMapping("del")
    public int delOne(@RequestBody List<ParkingDetailDto> parkingDetailDto){

        return parkingDetailService.del(parkingDetailDto);

    }

}
