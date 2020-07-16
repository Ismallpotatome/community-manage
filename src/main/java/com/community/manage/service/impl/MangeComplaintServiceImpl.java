package com.community.manage.service.impl;

import com.community.manage.domain.dto.MangeComplaintDto;
import com.community.manage.domain.dto.MangeWarrantyDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeComplaint;
import com.community.manage.domain.entity.TbMangeWarranty;
import com.community.manage.mapper.TbMangeComplaintMapper;
import com.community.manage.service.MangeComplaintService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MangeComplaintServiceImpl implements MangeComplaintService {
   @Resource
    TbMangeComplaintMapper mangeComplaintMapper;

    @Override
    public List<TbMangeComplaint> selectAll(SearchsDto searchsDto, int limit, int offset) {
        MangeComplaintDto mangeComplaintDto;

        String keyword = searchsDto.getKeyword();
        String begin = searchsDto.getStartDate();
        String end = searchsDto.getEndData();
        limit = (limit-1)*offset;

        List<TbMangeComplaint> tbMangeComplaints = mangeComplaintMapper.selectByCondition(keyword, begin, end, limit, offset);


        return tbMangeComplaints;
    }

    @Override
    public ResponseEntity insert(MangeComplaintDto mangeComplaintDto) {
        TbMangeComplaint tbMangeComplaint = new TbMangeComplaint();
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

