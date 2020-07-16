package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 活动管理
    */
@Data
public class TbMangeActivity {
    private Integer activityId;

    /**
    * 小区id
    */
    private Integer communityId;

    /**
    * 活动标题
    */
    private String activityTittle;

    /**
    * 活动地点
    */
    private String activityPlace;

    /**
    * 举办单位
    */
    private String activityUnit;

    /**
    * 开始时间
    */
    private String activityBegin;

    /**
    * 截止时间
    */
    private String activityEnd;

    /**
    * 创建时间
    */
    private Date activityCreateTime;

    /**
    * 0表示已过期,1表示仍有效
    */
    private Integer activityStatus;

    /**
    * 0表示删除,1表示存在
    */
    private Integer activityIsDel;
}