package com.community.manage.controller;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.service.ParkingDetailService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("detail")
public class ParkingDetailController {

    @Resource
    ParkingDetailService parkingDetailService;


    @PostMapping("select")
    public ResponseEntity<List<TbParkingDetail>> selectAll(@RequestBody SearchsDto searchsDto, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<TbParkingDetail> tbParkingDetails = parkingDetailService.selectAll(searchsDto,limit, offset);
        return ResponseEntity.success(tbParkingDetails);
    }


    //添加一条信息
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ParkingDetailDto parkingDetailDto){
        ResponseEntity responseEntity = parkingDetailService.insert(parkingDetailDto);

        return responseEntity;
    }

    //修改所有信息
    @PostMapping("updateAll")
    public ResponseEntity updateAll(@RequestBody ParkingDetailDto parkingDetailDto){

        ResponseEntity responseEntity = parkingDetailService.updateAll(parkingDetailDto);

        return responseEntity;
    }

    //批量删除信息
    @PostMapping("del")
    public ResponseEntity delOne(@RequestBody List<ParkingDetailDto> parkingDetailDto){

        ResponseEntity del = parkingDetailService.del(parkingDetailDto);

        return del;

    }

}
