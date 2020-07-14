package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 权限管理表
    */
@Data
public class Permissions {
    /**
    * 权限id
    */
    private Integer permissionsId;

    /**
    * 权限名称
    */
    private String permissionsName;

    /**
    * 描述
    */
    private String permissionsDescribe;

    /**
    * 创建时间
    */
    private Date permissionsCreatetime;

    /**
    * 更新时间
    */
    private Date permissionsUpdatetime;

    /**
    * 状态,1:已删除,0:未删除
    */
    private Integer permissionsStatus;
}