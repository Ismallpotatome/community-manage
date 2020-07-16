package com.community.manage.service.impl;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.mapper.TbParkingDetailMapper;
import com.community.manage.service.ParkingDetailService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingDetailServiceImpl implements ParkingDetailService {

    @Resource
    TbParkingDetailMapper parkingDetailMapper;


    @Override
    public List<TbParkingDetail> selectAll(SearchsDto searchsDto, int limit, int offset) {
        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbParkingDetail> tbParkingDetails = parkingDetailMapper.selectByCondition(keyword, begin, end, limit, offset);

        return tbParkingDetails;


    }

    @Override
    public ResponseEntity insert(ParkingDetailDto parkingDetailDto) {
        TbParkingDetail parkingDetail = new TbParkingDetail();
        BeanUtils.copyProperties(parkingDetailDto,parkingDetail);
        int i = parkingDetailMapper.insertParkingDetail(parkingDetail);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateAll(ParkingDetailDto parkingDetailDto) {
        TbParkingDetail parkingDetails = new TbParkingDetail();
        BeanUtils.copyProperties(parkingDetailDto,parkingDetails);
        int i = parkingDetailMapper.updateAll(parkingDetails);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }


    @Override
    public ResponseEntity del(List<ParkingDetailDto> list) {
        TbParkingDetail parkingDetails;

        int count = 0;
        for (ParkingDetailDto parkingDetailDto : list) {
            parkingDetails = new TbParkingDetail();
            BeanUtils.copyProperties(parkingDetailDto,parkingDetails);
            int i = parkingDetailMapper.delById(parkingDetails.getDetailId());
            count +=i;
        }
        if(count>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

}
