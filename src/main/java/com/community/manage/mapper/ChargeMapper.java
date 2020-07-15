package com.community.manage.mapper;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.entity.Charge;
import com.community.manage.domain.vo.ChargeBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeMapper {
    int deleteByPrimaryKey(Integer chargeId);

    int insert(Charge record);

    int insertSelective(Charge record);

    Charge selectByPrimaryKey(Integer chargeId);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);

    List<ChargeBean> selectAll();

    List<ChargeBean> selectByKey(@Param("chargeSearchDto") SearchDto chargeSearchDto);

    int updateStatusById(int chargeIds);

    int updateStatusByIds(@Param("chargeIds") int[] chargeIds);
}