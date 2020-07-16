package com.community.manage.controller;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.service.MangeActivityService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("activity")
public class MangeActivityController {
    @Resource
    MangeActivityService mangeActivityService;

    @PostMapping("select")
    public ResponseEntity<List<MangeActivityDto>> selectAll(@RequestBody SearchsDto searchsDto, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<MangeActivityDto> mangeActivityDtoList = mangeActivityService.selectAll(searchsDto, limit, offset);
        return ResponseEntity.success(mangeActivityDtoList);
    }

    //添加一条信息
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody MangeActivityDto mangeActivityDto){
        ResponseEntity insert = mangeActivityService.insert(mangeActivityDto);

        return insert;
    }

    //修改所有信息
    @PostMapping("updateAll")
    public ResponseEntity updateAll(@RequestBody MangeActivityDto mangeActivityDto){

        ResponseEntity responseEntity = mangeActivityService.updateAll(mangeActivityDto);

        return responseEntity;
    }

    //批量删除信息
    @PostMapping("del")
    public ResponseEntity delOne(@RequestBody List<MangeActivityDto> mangeActivityDto){

        ResponseEntity del = mangeActivityService.del(mangeActivityDto);

        return del;

    }


}
