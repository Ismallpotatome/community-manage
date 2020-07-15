package com.community.manage.service.impl;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.vo.ChargeBean;
import com.community.manage.service.ChargeService;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public class ChargeServiceImpl implements ChargeService {
    @Override
    public List<ChargeBean> showAllInfo() {
        return null;
    }

    @Override
    public List<ChargeBean> searchByKey(SearchDto chargeSearchDto) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(int chargeId) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(int[] chargeId) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity insertAssets() {
        return null;
    }

    @Override
    public ResponseEntity updateAssets() {
        return null;
    }
}
