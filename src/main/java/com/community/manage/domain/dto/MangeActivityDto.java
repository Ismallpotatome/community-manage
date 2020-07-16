package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbMangeActivity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MangeActivityDto extends TbMangeActivity implements Serializable {
    private Integer activityId;

    /**
     * 小区id
     */
    private Integer communityId;
    /**
     * 小区名字
     */
    private String communityName;

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
    @JsonFormat(pattern="yyyy-MM-dd ")
    private String activityBegin;

    /**
     * 截止时间
     */
    @JsonFormat(pattern="yyyy-MM-dd ")
    private String activityEnd;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
