package com.community.manage.controller;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.MangeMailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbMangeMail;
import com.community.manage.service.MangeMailService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("mail")
@RestController
public class MangeMailController {
    @Resource
    MangeMailService mangeMailService;

    @PostMapping("select")
    public ResponseEntity<List<MangeMailDto>> selectAll(@RequestBody SearchsDto searchsDto, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<MangeMailDto> mangeMailDtos = mangeMailService.selectAll(searchsDto, limit, offset);
        return ResponseEntity.success(mangeMailDtos);
    }

    //添加一条信息
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody MangeMailDto mangeMailDto){
        ResponseEntity insert = mangeMailService.insert(mangeMailDto);

        return insert;
    }

    //修改所有信息
    @PostMapping("updateAll")
    public ResponseEntity updateAll(@RequestBody MangeMailDto mangeMailDto){

        ResponseEntity responseEntity = mangeMailService.updateAll(mangeMailDto);

        return responseEntity;
    }

    //批量删除信息
    @PostMapping("del")
    public ResponseEntity delOne(@RequestBody List<MangeMailDto> mangeMailDto){

        ResponseEntity del = mangeMailService.del(mangeMailDto);

        return del;

    }
}
