package com.community.manage.service.impl;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.mapper.TbParkingDetailMapper;
import com.community.manage.service.ParkingDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingDetailServiceImpl implements ParkingDetailService {

    @Resource
    TbParkingDetailMapper parkingDetailMapper;


    @Override
    public List<TbParkingDetail> selectAll(String keyword, String begin, String end, int limit, int offset) {
        limit = (limit-1)*offset;



        List<TbParkingDetail> tbParkingDetails = parkingDetailMapper.selectByCondition(keyword, begin, end, limit, offset);

        return tbParkingDetails;


    }

    @Override
    public int insert(ParkingDetailDto parkingDetailDto) {
        TbParkingDetail parkingDetail = new TbParkingDetail();
        BeanUtils.copyProperties(parkingDetailDto,parkingDetail);
        return parkingDetailMapper.insertParkingDetail(parkingDetail);
    }

    @Override
    public int updateAll(ParkingDetailDto parkingDetailDto) {
        TbParkingDetail parkingDetails = new TbParkingDetail();
        BeanUtils.copyProperties(parkingDetailDto,parkingDetails);
        return parkingDetailMapper.updateAll(parkingDetails);
    }


    @Override
    public int del(List<ParkingDetailDto> list) {
        TbParkingDetail parkingDetails;

        int count = 0;
        for (ParkingDetailDto parkingDetailDto : list) {
            parkingDetails = new TbParkingDetail();
            BeanUtils.copyProperties(parkingDetailDto,parkingDetails);
            int i = parkingDetailMapper.delById(parkingDetails.getDetailId());
            count +=i;
        }
        return count;
    }

}
