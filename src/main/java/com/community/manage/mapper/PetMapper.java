package com.community.manage.mapper;

import com.community.manage.domain.entity.Pet;

public interface PetMapper {
    int deleteByPrimaryKey(Integer petId);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Integer petId);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
}