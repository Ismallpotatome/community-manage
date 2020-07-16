package com.community.manage.mapper;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.entity.ChargeItem;
import com.community.manage.domain.vo.ChargeItemBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeItemMapper {
    int deleteByPrimaryKey(Integer chargeId);

    int insert(ChargeItem record);

    int insertSelective(ChargeItem record);

    ChargeItem selectByPrimaryKey(Integer chargeId);

    int updateByPrimaryKeySelective(ChargeItem record);

    int updateByPrimaryKey(ChargeItem record);

    List<ChargeItemBean> selectAll();

    List<ChargeItemBean> selectByKey(@Param("chargeItemSearchDto") SearchDto chargeItemSearchDto);

    int updateStatusById(int chargeId);

    int updateStatusByIds(@Param("chargeIds") int[] chargeIds);
}