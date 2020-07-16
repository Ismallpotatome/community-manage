package com.community.manage.mapper.admins;

import com.community.manage.domain.dto.AdminRoleDto;

import java.util.List;

public interface AdminsRoleMapper {
    //获取全部"管理员角色"的信息
    List<AdminRoleDto> selectAll();
}
