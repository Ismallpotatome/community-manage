package com.community.manage.domain.vo;

import com.community.manage.domain.entity.Community;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
