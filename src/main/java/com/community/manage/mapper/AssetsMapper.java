package com.community.manage.mapper;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.entity.Assets;
import com.community.manage.domain.vo.AssetsBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetsMapper {
    int deleteByPrimaryKey(Integer assetsId);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer assetsId);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKey(Assets record);

    List<AssetsBean> selectAll();

    List<AssetsBean> selectByKey(@Param("assetsSearchDto") SearchDto assetsSearchDto);

    int updateStatusById(int assetsId);

    int updateStatusByIds(@Param("assetsIds") int[] assetsIds);

}