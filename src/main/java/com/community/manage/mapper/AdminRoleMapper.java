package com.community.manage.mapper;

import com.community.manage.domain.entity.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer adminRoleId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer adminRoleId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}