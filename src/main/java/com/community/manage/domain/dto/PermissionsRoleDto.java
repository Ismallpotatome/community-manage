package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限_角色的封装类
 */
@Data
public class PermissionsRoleDto implements Serializable {
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
}
