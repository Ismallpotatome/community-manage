package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 业主管理表
    */
@Data
public class Owner {
    /**
    * 业主人员id
    */
    private Integer ownerId;

    /**
    * 所属小区id,外键(小区)
    */
    private Integer communityId;

    /**
    * 成员名称
    */
    private String ownerName;

    /**
    * 身份证号
    */
    private String ownerIdcard;

    /**
    * 出生日期
    */
    private Date ownerBirth;

    /**
    * 电话号码
    */
    private String ownerPhone;

    /**
    * 职业
    */
    private String ownerProfession;

    /**
    * 性别,1:男,2:女,3:保密
    */
    private Integer ownerSex;

    /**
    * 成员类型,1:业主,2:家庭成员,3:租客
    */
    private Integer ownerType;

    /**
    * 成员照片
    */
    private String ownerPhoto;

    /**
    * 描述
    */
    private String ownerDescribe;

    /**
    * 创建时间
    */
    private Date ownerCreatetime;

    /**
    * 更新时间
    */
    private Date ownerUpdatetime;

    /**
    * 状态,1:已删除,0:未删除
    */
    private Integer ownerStatus;
}