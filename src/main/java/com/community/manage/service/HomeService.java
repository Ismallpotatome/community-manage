package com.community.manage.service;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.entity.Build;

import java.util.List;

public interface HomeService {
    //查询
    BuildDto selectByKeyword(BuildDto buildDto);
    //批量删除
    BuildDto deleteBatch(List<Build> builds);
    //添加一条记录
    String addOne(BuildDto buildDto);
    //修改一条记录
    BuildDto updateOne(BuildDto buildDto);
    //删除一条记录
    BuildDto deleteOne(BuildDto buildDto);
    //查询总条数
    int selectMsgNumber(BuildDto buildDto);
}
