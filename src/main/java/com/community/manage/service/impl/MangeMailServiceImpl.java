package com.community.manage.service.impl;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.MangeMailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbMangeMail;
import com.community.manage.mapper.TbMangeMailMapper;
import com.community.manage.service.MangeMailService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MangeMailServiceImpl implements MangeMailService {
    @Resource
    TbMangeMailMapper mangeMailMapper;
    @Override
    public List<TbMangeMail> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeMailDto mangeMailDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeMail> tbMangeMails = mangeMailMapper.selectByCondition(keyword, begin, end, limit, offset);


        return tbMangeMails;
    }

    @Override
    public ResponseEntity insert(MangeMailDto mangeMainDto) {
        TbMangeMail mangeMail = new TbMangeMail();
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
