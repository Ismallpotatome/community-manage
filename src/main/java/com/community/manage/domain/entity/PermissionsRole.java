package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class PermissionsRole {
    /**
    * 权限_角色的id
    */
    private Integer permissionsRoleId;

    /**
    * 权限id,外键(权限)
    */
    private Integer permissionsRolePid;

    /**
    * 角色id,外键(角色)
    */
    private Integer permissionsRoleRid;

    /**
    * 创建时间
    */
    private Date permissionsRoleCreatetime;

    /**
    * 更新时间
    */
    private Date permissionsRoleUpdatetime;

    /**
    * 1:已删除,0:未删除
    */
    private Integer permissionsRoleStatus;
}