package com.community.manage.controller;

import com.community.manage.domain.dto.MangeComplaintDto;
import com.community.manage.domain.dto.MangeWarrantyDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeComplaint;
import com.community.manage.domain.entity.TbMangeWarranty;
import com.community.manage.service.MangeComplaintService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("complaint")
@RestController
public class MangeComplaintController {

    @Resource
    MangeComplaintService mangeComplaintService;

    @PostMapping("select")
    public ResponseEntity<List<MangeComplaintDto>> selectAll(@RequestBody SearchsDto searchsDto, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset){


        List<MangeComplaintDto> mangeComplaintDtos = mangeComplaintService.selectAll(searchsDto, limit, offset);
        return ResponseEntity.success(mangeComplaintDtos);
    }

    //添加一条信息
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody MangeComplaintDto mangeComplaintDto){
        ResponseEntity insert = mangeComplaintService.insert(mangeComplaintDto);

        return insert;
    }

    //修改所有信息
    @PostMapping("updateAll")
    public ResponseEntity updateAll(@RequestBody MangeComplaintDto mangeComplaintDto){

        ResponseEntity responseEntity = mangeComplaintService.updateAll(mangeComplaintDto);

        return responseEntity;
    }

    //批量删除信息
    @PostMapping("del")
    public ResponseEntity delOne(@RequestBody List<MangeComplaintDto> mangeComplaintDto){

        ResponseEntity del = mangeComplaintService.del(mangeComplaintDto);

        return del;

    }

}
