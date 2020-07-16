package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * "管理员角色"的封装信息
 */
@Data
public class AdminRoleDto implements Serializable {
    /**
     * 角色id
     */
    private Integer adminRoleId;

    /**
     * 角色名称
     */
    private String adminRoleName;

    /**
     * 描述
     */
    private String adminRoleDescribe;

    /**
     * 创建时间
     */
    private Date adminRoleCreatetime;

    /**
     * 状态,1:已删除,0:未删除
     */
    private Integer adminRoleStatus;

}
