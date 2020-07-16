package com.community.manage.service.impl;




import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.mapper.CommunityDtoMapper;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.TbParkingUserMapper;
import com.community.manage.service.ParkingUserService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingUserServiceImpl implements ParkingUserService {
    @Resource
    TbParkingUserMapper parkingUserMapper;
    @Resource
    CommunityMapper communityMapper;




    @Override
    public List<ParkingUseDto> selectAll(SearchsDto searchsDto,int limit,int offset) {
        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();


        limit = (limit-1)*offset;
        List<TbParkingUser> tbParkingUsers = parkingUserMapper.selectByCondition(keyword, begin, end, limit, offset);

//      这里开始进行转化,把TbParkingUser对象转化为ParkingUserDto对象
        ParkingUseDto parkingUseDto;
        List<ParkingUseDto> parkingUseDtoList = new ArrayList<>();

        for (TbParkingUser tbParkingUser : tbParkingUsers) {
            //获取外键id
            Integer communityId = tbParkingUser.getCommunityId();
            //用id从community中找到对象
            Community community = communityMapper.selectOneCommunity(communityId);

            parkingUseDto =new ParkingUseDto();
            BeanUtils.copyProperties(tbParkingUser,parkingUseDto);
            parkingUseDto.setCommunityName(community.getCommunityName());
            parkingUseDtoList.add(parkingUseDto);

        }

            return parkingUseDtoList;


    }


    @Override
    @Transactional
    public ResponseEntity insert(ParkingUseDto parkingUserDto) {
        TbParkingUser parkingUser = new TbParkingUser();

        String communityName = parkingUserDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        parkingUserDto.setCommunityId(community.getCommunityId());


        BeanUtils.copyProperties(parkingUserDto,parkingUser);
        int i = parkingUserMapper.insertParkingUser(parkingUser);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateById(int status,int id) {
        int i = parkingUserMapper.updateByStatus(status, id);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateAll(ParkingUseDto parkingUseDto) {
        TbParkingUser parkingUser = new TbParkingUser();

        String communityName = parkingUseDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        parkingUseDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(parkingUseDto,parkingUser);
        int i = parkingUserMapper.updateAll(parkingUser);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity del(List<ParkingUseDto> list) {
        TbParkingUser parkingUse;
        int count = 0;
        for (ParkingUseDto parkingUseDto : list) {
            parkingUse = new TbParkingUser();
            BeanUtils.copyProperties(parkingUseDto,parkingUse);
            int i = parkingUserMapper.delById(parkingUse.getUserId());
            count +=i;
        }
        if(count>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }
}
