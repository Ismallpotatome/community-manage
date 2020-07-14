package com.community.manage.service.impl;

import com.community.manage.domain.dto.AssetsSearchDto;
import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.mapper.AssetsMapper;
import com.community.manage.service.AssetsService;
import com.community.manage.util.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AssetsServiceImpl implements AssetsService {
    @Resource
    AssetsMapper assetsMapper;
    @Override
    public AssetsBean showAllInfo() {
        AssetsBean assetsBean = assetsMapper.selectAll();
        return assetsBean;
    }

    @Override
    public AssetsBean searchByKey(AssetsSearchDto assetsSearchDto) {
        AssetsBean assetsBean = assetsMapper.selectByKey(assetsSearchDto);
        return assetsBean;
    }

    @Override
    public ResponseEntity deleteById(int assetsId) {
        int i = assetsMapper.updateStatusById(assetsId);
        if(i>0) {
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error();
        }
    }

    @Override
    public ResponseEntity deleteById(int[] assetsIds) {
        return null;
    }
}
