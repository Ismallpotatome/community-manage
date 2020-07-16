package com.community.manage.service.impl;


import com.community.manage.domain.dto.MangeMailDto;
import com.community.manage.domain.dto.MangeWarrantyDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.TbMangeMail;
import com.community.manage.domain.entity.TbMangeWarranty;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.TbMangeWarrantyMapper;
import com.community.manage.service.MangeWarrantyService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangeWarrantyServiceImpl implements MangeWarrantyService {

    @Resource
    TbMangeWarrantyMapper warrantyMapper;
    @Resource
    CommunityMapper communityMapper;

    @Override
    public List<MangeWarrantyDto> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeWarrantyDto mangeWarrantyDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeWarranty> tbMangeWarranties = warrantyMapper.selectByCondition(keyword, begin, end, limit, offset);


//        这里开始进行转化,把TbParkingUser对象转化为ParkingUserDto对象
        MangeWarrantyDto mangeWarrantyDto1;
        List<MangeWarrantyDto> mangeWarrantyDtoList = new ArrayList<>();

        for (TbMangeWarranty mangeWarranty: tbMangeWarranties) {
            //获取外键id
            Integer communityId = mangeWarranty.getCommunityId();
            //用id从community中找到对象
            Community community = communityMapper.selectOneCommunity(communityId);

            mangeWarrantyDto1 =new MangeWarrantyDto();
            BeanUtils.copyProperties(mangeWarranty,mangeWarrantyDto1);
            mangeWarrantyDto1.setCommunityName(community.getCommunityName());
            mangeWarrantyDtoList.add(mangeWarrantyDto1);

        }

        return mangeWarrantyDtoList;
    }

    @Override
    public ResponseEntity insert(MangeWarrantyDto mangeWarrantyDto) {
        TbMangeWarranty tbMangeWarranty =new TbMangeWarranty();

        String communityName = mangeWarrantyDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeWarrantyDto.setCommunityId(community.getCommunityId());


        BeanUtils.copyProperties(mangeWarrantyDto,tbMangeWarranty);
        int i = warrantyMapper.insertMangeWarranty(tbMangeWarranty);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateAll(MangeWarrantyDto mangeWarrantyDto) {
        TbMangeWarranty tbMangeWarranty =new TbMangeWarranty();


        String communityName = mangeWarrantyDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeWarrantyDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeWarrantyDto,tbMangeWarranty);
        int i =warrantyMapper.updateAll(tbMangeWarranty);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity del(List<MangeWarrantyDto> list) {
        TbMangeWarranty tbMangeWarranty;

        int count = 0;
        for (MangeWarrantyDto mangeWarrantyDto : list) {
            tbMangeWarranty = new TbMangeWarranty();
            BeanUtils.copyProperties(mangeWarrantyDto,tbMangeWarranty);
            int i =warrantyMapper.delById(tbMangeWarranty.getWarrantyId());
            count +=i;
        }
        if(count>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

}
