package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PetDto implements Serializable {
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
     * 所属成员名称
     */
    private String ownerName;

}
