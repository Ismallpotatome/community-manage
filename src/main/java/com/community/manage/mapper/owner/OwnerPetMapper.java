package com.community.manage.mapper.owner;

import com.community.manage.domain.dto.PetDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerPetMapper {
    //根据关键字和时间进行分页查询
    List<PetDto> selectBySearchAndLimit(@Param("searchDto") SearchsDto searchDto);
    //添加"宠物"
    int insertPet(@Param("pet")Pet pet);
    //根据id批量修改数据状态
    int updateBatchPet(@Param("petIdList") List<Integer> petIdList);
    //修改信息
    int updatePet(@Param("pet") Pet pet);
    //根据id单个修改数据状态
    int updateSinglePet(@Param("petId") Integer petId);
}
