package com.community.manage.service;



import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.domain.entity.TbParkingUser;


import java.util.List;

public interface ParkingUserService {
    List<TbParkingUser> selectAll(String keyword, String begin, String end, int limit, int offset);


    int insert(ParkingUseDto parkingUserDto);

    int updateById(int status,int id);

    public int updateAll(ParkingUseDto parkingUseDto);

    int del(List<ParkingUseDto> list);


}
