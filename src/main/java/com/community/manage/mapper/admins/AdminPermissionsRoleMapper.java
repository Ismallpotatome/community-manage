package com.community.manage.mapper.admins;

import org.apache.ibatis.annotations.Param;

public interface AdminPermissionsRoleMapper {
    //插入权限_角色
    int insertPermissionsRole(@Param("permissionsId") Integer permissionsId, @Param("roleId") Integer roleId);
}
