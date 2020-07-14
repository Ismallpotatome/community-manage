package com.community.manage.mapper;

import com.community.manage.domain.entity.Permissions;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer permissionsId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer permissionsId);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}