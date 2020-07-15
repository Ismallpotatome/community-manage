package com.community.manage.domain.vo;

import com.community.manage.domain.entity.Community;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChargeBean implements Serializable {
    /**
     * 收费项目id
     */
    private Integer chargeId;

    /**
     * 外键字段，对应小区表的主键
     */
    private Integer communityId;

    /**
     * 收费编号
     */
    private String chargeNum;

    /**
     * 收费名称
     */
    private String chargeName;

    /**
     * 创建时间
     */
    private Date chargeEstablishDate;

    /**
     * 1为有效数据  0为错误数据
     */
    private Integer chargeStatus;
    /**
     * 对应小区
     */
    private Community community;
}
