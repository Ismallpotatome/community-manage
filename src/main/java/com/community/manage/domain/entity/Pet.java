package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 宠物管理表
    */
@Data
public class Pet {
    /**
    * 宠物id
    */
    private Integer petId;

    /**
    * 所属成员id,外键(成员)
    */
    private Integer petOwnerId;

    /**
    * 宠物名称
    */
    private String petName;

    /**
    * 宠物颜色
    */
    private String petColor;

    /**
    * 收养时间
    */
    private Date petAdoptiontime;

    /**
    * 宠物图片
    */
    private String petPhoto;

    /**
    * 描述
    */
    private String petDescribe;

    /**
    * 创建时间
    */
    private Date petCreatetime;

    /**
    * 更新时间
    */
    private Date petUpdatetime;

    /**
    * 状态,1:已删除,0:未删除
    */
    private Integer petStatus;
}