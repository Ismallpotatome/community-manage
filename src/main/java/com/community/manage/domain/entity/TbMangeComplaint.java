package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 投诉管理
    */
@Data
public class TbMangeComplaint {
    private Integer complaintId;

    /**
    * 小区id
    */
    private Integer communityId;

    /**
    * 投诉人员
    */
    private String complaintUse;

    /**
    * 投诉原因
    */
    private String complaintReason;

    /**
    * 投诉原因描述
    */
    private String complaintDescribe;

    /**
    * 创建时间
    */
    private Date complaintCreateTime;

    /**
    * 0表示不匿名,1表示匿名
    */
    private Integer complaintStatus;

    /**
    * 0表示已删除,1表示未删除
    */
    private Integer complaintIsDel;
}