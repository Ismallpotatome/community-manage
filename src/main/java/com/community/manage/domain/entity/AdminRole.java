package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 管理员角色管理表
    */
@Data
public class AdminRole {
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
    * 更新时间
    */
    private Date adminRoleUpdatetime;

    /**
    * 状态,1:已删除,0:未删除
    */
    private Integer adminRoleStatus;
}