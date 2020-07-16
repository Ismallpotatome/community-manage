package com.community.manage.service.impl;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.TbMangeActivityMapper;
import com.community.manage.service.MangeActivityService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangeActivityServiceImpl implements MangeActivityService {
    @Resource
    TbMangeActivityMapper mangeActivityMapper;
    @Resource
    CommunityMapper communityMapper;

    @Override
    public List<MangeActivityDto> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeActivityDto mangeActivityDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeActivity> tbMangeActivities = mangeActivityMapper.selectByCondition(keyword, begin, end, limit, offset);

//      这里开始进行转化,把TbParkingUser对象转化为ParkingUserDto对象
        MangeActivityDto mangeActivityDto1;
        List<MangeActivityDto> mangeActivityDtoList = new ArrayList<>();

        for (TbMangeActivity tbMangeActivity: tbMangeActivities) {
            //获取外键id
            Integer communityId = tbMangeActivity.getCommunityId();
            //用id从community中找到对象
            Community community = communityMapper.selectOneCommunity(communityId);

            mangeActivityDto1 =new MangeActivityDto();
            BeanUtils.copyProperties(tbMangeActivity,mangeActivityDto1 );
            mangeActivityDto1.setCommunityName(community.getCommunityName());
            mangeActivityDtoList.add(mangeActivityDto1);

        }

        return mangeActivityDtoList;

    }

    @Override
    public ResponseEntity insert(MangeActivityDto mangeActivityDto) {
        TbMangeActivity mangeActivity = new TbMangeActivity();

        String communityName = mangeActivityDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeActivityDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeActivityDto,mangeActivity);

        int i =mangeActivityMapper.insertMangeActivity(mangeActivity);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateAll(MangeActivityDto mangeActivityDto) {
        TbMangeActivity mangeActivity = new TbMangeActivity();

        String communityName = mangeActivityDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeActivityDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeActivityDto,mangeActivity);
        int i =mangeActivityMapper.updateAll(mangeActivity);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity del(List<MangeActivityDto> list) {
        TbMangeActivity mangeActivity;

        int count = 0;
        for (MangeActivityDto mangeActivityDto : list) {
            mangeActivity = new TbMangeActivity();
            BeanUtils.copyProperties(mangeActivityDto,mangeActivity);
            int i = mangeActivityMapper.delById(mangeActivity.getActivityId());
            count +=i;
        }
        if(count>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

}
