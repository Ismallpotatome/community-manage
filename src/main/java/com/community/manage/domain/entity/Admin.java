package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 管理员管理表
    */
@Data
public class Admin {
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
    * 更新时间
    */
    private Date adminUpdatetime;

    /**
    * 状态,1:已删除,0:未删除
    */
    private Integer adminStatus;
}