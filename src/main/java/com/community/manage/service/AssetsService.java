package com.community.manage.service;

import com.community.manage.domain.dto.AssetsSearchDto;
import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.util.ResponseEntity;

public interface AssetsService {

    AssetsBean showAllInfo();

    AssetsBean searchByKey(AssetsSearchDto assetsSearchDto);

    ResponseEntity deleteById(int assetsId);

    ResponseEntity deleteById(int[] assetsIds);
}
