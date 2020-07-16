package com.community.manage.service;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface MangeActivityService {


    List<MangeActivityDto> selectAll(SearchsDto searchsDto, int limit, int offset);


    ResponseEntity insert(MangeActivityDto mangeActivityDto);



    ResponseEntity updateAll(MangeActivityDto mangeActivityDto);

    ResponseEntity del(List<MangeActivityDto> list);
}
