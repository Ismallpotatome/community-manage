package com.community.manage.mapper;

import com.community.manage.domain.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerMapper {
    int deleteByPrimaryKey(Integer ownerId);

    int insert(Owner record);

    int insertSelective(Owner record);

    Owner selectByPrimaryKey(Integer ownerId);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);

    //根据关键字和时间进行分页查询
//    List<Owner> selectBySearchAndLimit(@Param("keyword") String keyword,
//                                       @Param("startDate") String startDate,
//                                       @Param("endData") String endData,
//                                       @Param("limit") String limit,
//                                       @Param("size") String size
//    );
}