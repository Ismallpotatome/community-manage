package com.community.manage.mapper.owner;

import com.community.manage.domain.dto.OwnerDto;
import com.community.manage.domain.dto.PetDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.domain.entity.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerInfoMapper {
    //根据小区id查询业主的名称和id
    List<OwnerDto> selectByCommunityId(@Param("communityId") Integer communityId);
    //根据关键字和时间进行分页查询
    List<OwnerDto> selectBySearchAndLimit(@Param("searchDto") SearchsDto searchDto);
    //添加"业主"
    int insertPersonnel(@Param("owner") Owner owner);
    //根据id批量修改数据状态
    int updateBatchPersonnel(@Param("personnelIdList") List<Integer> personnelIdList);
    //修改信息
    int updatePersonnel(@Param("owner") Owner owner);
    //根据id单个修改数据状态
    int updateSinglePersonnel(@Param("personnelId") Integer ppersonnelId);
}
