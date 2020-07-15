package com.community.manage.service;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.vo.ChargeBean;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface ChargeService {
    List<ChargeBean> showAllInfo();

    List<ChargeBean> searchByKey(SearchDto chargeSearchDto);

    ResponseEntity deleteById(int chargeId);

    ResponseEntity deleteById(int[] chargeId) throws Exception;

    ResponseEntity insertAssets();

    ResponseEntity updateAssets();
}
