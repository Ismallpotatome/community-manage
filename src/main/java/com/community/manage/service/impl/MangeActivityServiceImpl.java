package com.community.manage.service.impl;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.ParkingDetailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbParkingDetail;
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

    @Override
    public List<TbMangeActivity> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeActivityDto mangeActivityDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeActivity> tbMangeActivities = mangeActivityMapper.selectByCondition(keyword, begin, end, limit, offset);


        return tbMangeActivities;

    }

    @Override
    public ResponseEntity insert(MangeActivityDto mangeActivityDto) {
        TbMangeActivity mangeActivity = new TbMangeActivity();
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
