package com.community.manage.service;

import com.community.manage.domain.dto.AssetsInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface AssetsService {

    List<AssetsBean> showAllInfo();

    List<AssetsBean> searchByKey(SearchDto assetsSearchDto);

    ResponseEntity deleteById(int assetsId);

    ResponseEntity deleteById(int[] assetsIds) throws Exception;

    ResponseEntity insertAssets(AssetsInfoDto assetsNewInfo);

    ResponseEntity updateAssets(AssetsInfoDto assetsInfo);
}
