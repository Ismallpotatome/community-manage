package com.community.manage.service;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.util.ResponseEntity;


import java.util.List;

public interface ParkingDetailService {

    List<ParkingDetailDto> selectAll(SearchsDto searchsDto, int limit, int offset);


    ResponseEntity insert(ParkingDetailDto parkingDetailDto);



    ResponseEntity updateAll(ParkingDetailDto parkingDetail);

    ResponseEntity del(List<ParkingDetailDto> list);

}
