package com.community.manage.service.impl;

import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.TbParkingDetailMapper;
import com.community.manage.mapper.TbParkingUserMapper;
import com.community.manage.service.ParkingDetailService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingDetailServiceImpl implements ParkingDetailService {

    @Resource
    TbParkingDetailMapper parkingDetailMapper;
    @Resource
    CommunityMapper communityMapper;
    @Resource
    TbParkingUserMapper parkingUserMapper;


    @Override
    public List<ParkingDetailDto> selectAll(SearchsDto searchsDto, int limit, int offset) {
        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbParkingDetail> tbParkingDetails = parkingDetailMapper.selectByCondition(keyword, begin, end, limit, offset);

        //      这里开始进行转化,把TbParkingUser对象转化为ParkingUserDto对象
        ParkingDetailDto parkingDetailDto;
        List<ParkingDetailDto> parkingDetailDtoList = new ArrayList<>();

        for (TbParkingDetail tbParkingDetail : tbParkingDetails) {
            //获取外键id
            Integer communityId = tbParkingDetail .getCommunityId();
            //用id从community中找到对象
            Community community = communityMapper.selectOneCommunity(communityId);

            parkingDetailDto =new ParkingDetailDto();
            BeanUtils.copyProperties(tbParkingDetail,parkingDetailDto);
            parkingDetailDto.setCommunityName(community.getCommunityName());
            parkingDetailDtoList.add(parkingDetailDto);

        }

        return parkingDetailDtoList;

    }

    @Override
    @Transactional
    public ResponseEntity insert(ParkingDetailDto parkingDetailDto) {
        TbParkingDetail parkingDetail = new TbParkingDetail();


        String communityName = parkingDetailDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        parkingDetailDto.setCommunityId(community.getCommunityId());

        String userNumber = parkingDetailDto.getUserNumber();
        TbParkingUser parkingUser = parkingUserMapper.selectByNum(userNumber);
        parkingDetailDto.setUserId(parkingUser.getUserId());

        BeanUtils.copyProperties(parkingDetailDto,parkingDetail);
        int i = parkingDetailMapper.insertParkingDetail(parkingDetail);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    @Transactional
    public ResponseEntity updateAll(ParkingDetailDto parkingDetailDto) {
        TbParkingDetail parkingDetails = new TbParkingDetail();

        String communityName = parkingDetailDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        parkingDetailDto.setCommunityId(community.getCommunityId());

        String userNumber = parkingDetailDto.getUserNumber();
        TbParkingUser parkingUser = parkingUserMapper.selectByNum(userNumber);
        parkingDetailDto.setUserId(parkingUser.getUserId());


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
