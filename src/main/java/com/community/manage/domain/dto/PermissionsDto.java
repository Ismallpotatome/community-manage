package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * "权限"信息的封装类
 */
@Data
public class PermissionsDto implements Serializable {
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
     * 状态,1:已删除,0:未删除
     */
    private Integer permissionsStatus;
}
