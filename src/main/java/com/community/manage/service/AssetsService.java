package com.community.manage.service;

import com.community.manage.domain.dto.AssetsSearchDto;
import com.community.manage.domain.vo.AssetsBean;

public interface AssetsService {
    AssetsBean showAllInfo();
    String searchByKey(AssetsSearchDto assetsSearchDto);
}
