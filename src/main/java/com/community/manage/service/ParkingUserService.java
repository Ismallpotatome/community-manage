package com.community.manage.service;



import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.util.ResponseEntity;


import java.util.List;

public interface ParkingUserService {
    List<TbParkingUser> selectAll(SearchsDto searchsDto,int limit,int offset);


    ResponseEntity insert(ParkingUseDto parkingUserDto);

    ResponseEntity  updateById(int status,int id);

    ResponseEntity  updateAll(ParkingUseDto parkingUseDto);

    ResponseEntity  del(List<ParkingUseDto> list);


}
