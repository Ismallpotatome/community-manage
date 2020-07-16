package com.community.manage.controller;

import com.community.manage.domain.dto.MangeWarrantyDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeWarranty;
import com.community.manage.service.MangeWarrantyService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("warranty")
public class MangeWarrantyController {

    @Resource
    MangeWarrantyService mangeWarrantyService;

    @PostMapping("select")
    public ResponseEntity<List<TbMangeWarranty>> selectAll(@RequestBody SearchsDto searchsDto, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<TbMangeWarranty> tbMangeWarranties = mangeWarrantyService.selectAll(searchsDto, limit, offset);
        return ResponseEntity.success(tbMangeWarranties);
    }

    //添加一条信息
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody MangeWarrantyDto mangeWarrantyDto){
        ResponseEntity insert = mangeWarrantyService.insert(mangeWarrantyDto);

        return insert;
    }

    //修改所有信息
    @PostMapping("updateAll")
    public ResponseEntity updateAll(@RequestBody MangeWarrantyDto mangeWarrantyDto){

        ResponseEntity responseEntity = mangeWarrantyService.updateAll(mangeWarrantyDto);

        return responseEntity;
    }

    //批量删除信息
    @PostMapping("del")
    public ResponseEntity delOne(@RequestBody List<MangeWarrantyDto> mangeWarrantyDto){

        ResponseEntity del = mangeWarrantyService.del(mangeWarrantyDto);

        return del;

    }

}
