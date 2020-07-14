package com.community.manage.mapper;

import com.community.manage.domain.entity.PermissionsRole;

public interface PermissionsRoleMapper {
    int deleteByPrimaryKey(Integer permissionsRoleId);

    int insert(PermissionsRole record);

    int insertSelective(PermissionsRole record);

    PermissionsRole selectByPrimaryKey(Integer permissionsRoleId);

    int updateByPrimaryKeySelective(PermissionsRole record);

    int updateByPrimaryKey(PermissionsRole record);
}