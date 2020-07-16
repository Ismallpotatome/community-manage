package com.community.manage.service;

import com.community.manage.domain.dto.ChargeItemInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.vo.ChargeItemBean;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface ChargeItemService {

    List<ChargeItemBean> showAllInfo();

    List<ChargeItemBean> searchByKey(SearchDto chargeItemSearchDto);

    ResponseEntity deleteById(int chargeId);

    ResponseEntity deleteById(int[] chargeIds) throws Exception;

    ResponseEntity insertChargeItem(ChargeItemInfoDto chargeItemNewInfo);

    ResponseEntity updateChargeItem(ChargeItemInfoDto chargeItemInfo);
}
