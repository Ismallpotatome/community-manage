package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 保修管理
    */
@Data
public class TbMangeWarranty {
    private Integer warrantyId;

    /**
    * 小区id
    */
    private Integer communityId;

    /**
    * 报修人员
    */
    private String warrantyUse;

    /**
    * 设备名称
    */
    private String warrantyEquipment;

    /**
    * 报修描述
    */
    private String warrantyDescribe;

    /**
    * 创建时间
    */
    private Date warrantyCreateTime;

    /**
    * 0表示待处理,1表示已处理
    */
    private Integer warrantyStatus;

    /**
    * 0表示已删除,1表示未删除
    */
    private Integer warrantyIsDel;
}