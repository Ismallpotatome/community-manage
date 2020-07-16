package com.community.manage.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * 管理员信息的封装类
 */
@Data
public class AdminDto {
    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 登录名
     */
    private String adminName;

    /**
     * 手机
     */
    private String adminPhone;

    /**
     * 管理员角色id,外键(管理员角色)
     */
    private Integer adminRoleId;

    /**
     * 管理员图片
     */
    private String adminPhoto;

    /**
     * 密码
     */
    private String adminPassword;

    /**
     * 创建时间
     */
    private Date adminCreatetime;

    /**
     * 管理员角色名称
     */
    private String adminRoleName;
    /**
     * 状态,1:已删除,0:未删除
     */
    private Integer adminStatus;
}
