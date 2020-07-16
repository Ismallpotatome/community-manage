package com.community.manage.service.impl;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.MangeMailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbMangeMail;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.TbMangeMailMapper;
import com.community.manage.service.MangeMailService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangeMailServiceImpl implements MangeMailService {
    @Resource
    TbMangeMailMapper mangeMailMapper;
    @Resource
    CommunityMapper communityMapper;
    @Override
    public List<MangeMailDto> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeMailDto mangeMailDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeMail> tbMangeMails = mangeMailMapper.selectByCondition(keyword, begin, end, limit, offset);


//        这里开始进行转化,把TbParkingUser对象转化为ParkingUserDto对象
        MangeMailDto mangeMailDto1;
        List<MangeMailDto> mangeMailDtos = new ArrayList<>();

        for (TbMangeMail tbMangeMail: tbMangeMails) {
            //获取外键id
            Integer communityId = tbMangeMail.getCommunityId();
            //用id从community中找到对象
            Community community = communityMapper.selectOneCommunity(communityId);

            mangeMailDto1 =new MangeMailDto();
            BeanUtils.copyProperties(tbMangeMail,mangeMailDto1);
            mangeMailDto1.setCommunityName(community.getCommunityName());
            mangeMailDtos.add(mangeMailDto1);

        }

        return mangeMailDtos;
    }

    @Override
    public ResponseEntity insert(MangeMailDto mangeMainDto) {
        TbMangeMail mangeMail = new TbMangeMail();

        String communityName = mangeMainDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeMainDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeMainDto,mangeMail);
        int i = mangeMailMapper.insertMangeActivity(mangeMail);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateAll(MangeMailDto mangeMainDto) {

        TbMangeMail mangeMail = new TbMangeMail();

        String communityName = mangeMainDto.getCommunityName();
        Community community = communityMapper.selectCommunityByName(communityName);
        mangeMainDto.setCommunityId(community.getCommunityId());

        BeanUtils.copyProperties(mangeMainDto,mangeMail);
        int i = mangeMailMapper.updateAll(mangeMail);
        if(i>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity del(List<MangeMailDto> list) {
        TbMangeMail mangeMail;

        int count = 0;
        for (MangeMailDto mangeMailDto : list) {
            mangeMail = new TbMangeMail();
            BeanUtils.copyProperties(mangeMailDto,mangeMail);
            int i = mangeMailMapper.delById(mangeMail.getMailId());
            count +=i;
        }
        if(count>0) {
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }
}
