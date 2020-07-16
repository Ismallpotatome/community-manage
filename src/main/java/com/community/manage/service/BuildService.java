package com.community.manage.service;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.entity.Build;
import com.community.manage.util.TwoResult;

import java.util.List;

public interface BuildService {
    //根据关键字查询
    TwoResult<List<BuildDto>> selectByKeyword(BuildDto buildDto);
    //删除一条栋数记录
    List<BuildDto> deleteOne(BuildDto buildDto);
    //批量删除栋数记录
    List<BuildDto> deleteBatch(List<BuildDto> buildDto);
    //添加一条记录
    String insertOne(BuildDto buildDto);
    //修改一条记录
    List<BuildDto> updateOne(BuildDto buildDto);


}
