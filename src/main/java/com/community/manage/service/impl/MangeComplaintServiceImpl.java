package com.community.manage.service.impl;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.MangeComplaintDto;
import com.community.manage.domain.dto.MangeWarrantyDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbMangeComplaint;
import com.community.manage.domain.entity.TbMangeWarranty;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.TbMangeComplaintMapper;
import com.community.manage.service.MangeComplaintService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangeComplaintServiceImpl implements MangeComplaintService {
   @Resource
    TbMangeComplaintMapper mangeComplaintMapper;
   @Resource
    CommunityMapper communityMapper;

    @Override
    public List<MangeComplaintDto> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeComplaintDto mangeComplaintDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeComplaint> tbMangeComplaints = mangeComplaintMapper.selectByCondition(keyword, begin, end, limit, offset);


//      这里开始进行转化,把TbParkingUser对象转化为ParkingUserDto对象
        MangeComplaintDto mangeComplaintDto1;
        List<MangeComplaintDto> mangeComplaintDtoList = new ArrayList<>();

        for (TbMangeComplaint tbMangeComplaint: tbMangeComplaints) {
            //获取外键id
            Integer communityId = tbMangeComplaint.getCommunityId();
            //用id从community中找到对象
            Community community = communityMapper.selectOneCommunity(communityId);

            mangeComplaintDto1 =new MangeComplaintDto();
            BeanUtils.copyProperties(tbMangeComplaint,mangeComplaintDto1);
            mangeComplaintDto1.setCommunityName(community.getCommunityName());
            mangeComplaintDtoList.add(mangeComplaintDto1);

        }

        return mangeComplaintDtoList;
    }

    @Override
    public ResponseEntity insert(MangeComplaintDto mangeComplaintDto) {
        TbMangeComplaint tbMangeComplaint = new TbMangeComplaint();

        String communityName = mangeComplaintDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeComplaintDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeComplaintDto,tbMangeComplaint);
        int i = mangeComplaintMapper.insertMangeComplaint(tbMangeComplaint);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateAll(MangeComplaintDto mangeComplaintDto) {
        TbMangeComplaint tbMangeComplaint = new TbMangeComplaint();

        String communityName = mangeComplaintDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeComplaintDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeComplaintDto,tbMangeComplaint);
        int i = mangeComplaintMapper.updateAll(tbMangeComplaint);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity del(List<MangeComplaintDto> list) {
        TbMangeComplaint tbMangeComplaint;

        int count = 0;
        for (MangeComplaintDto mangeComplaintDto : list) {
            tbMangeComplaint = new TbMangeComplaint();
            BeanUtils.copyProperties(mangeComplaintDto,tbMangeComplaint);
            int i = mangeComplaintMapper.delById(tbMangeComplaint.getComplaintId());
            count +=i;
        }
        if(count>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    }

