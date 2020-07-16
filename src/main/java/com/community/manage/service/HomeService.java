package com.community.manage.service;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.dto.HomeDto;
import com.community.manage.domain.entity.Build;
import com.community.manage.util.TwoResult;

import java.util.List;

public interface HomeService {
    //查询
    TwoResult<List<HomeDto>> selectByKeyword(HomeDto homeDto);
    //批量删除
    List<HomeDto> deleteBatch(List<HomeDto> homeDtos);
    //添加一条记录
    String addOne(HomeDto homeDto);
    //修改一条记录
    String updateOne(HomeDto homeDto);
    //删除一条记录
    List<HomeDto> deleteOne(HomeDto homeDto);
}
