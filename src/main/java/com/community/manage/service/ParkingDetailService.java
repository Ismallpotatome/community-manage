package com.community.manage.service;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.entity.TbParkingDetail;


import java.util.List;

public interface ParkingDetailService {

    List<TbParkingDetail> selectAll(String keyword, String begin, String end, int limit, int offset);


    int insert(ParkingDetailDto parkingDetailDto);



    public int updateAll(ParkingDetailDto parkingDetail);

    int del(List<ParkingDetailDto> list);

}
