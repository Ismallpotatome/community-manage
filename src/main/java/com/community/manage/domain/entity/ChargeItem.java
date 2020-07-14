package com.community.manage.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
    * 收费项目表
    */
@Data
public class ChargeItem {
    /**
    * 收费项目id
    */
    private Integer chargeId;

    /**
    * 收费业主
    */
    private String chargeOwner;

    /**
    * 应收金额
    */
    private BigDecimal receivableAmount;

    /**
    * 实收金额
    */
    private BigDecimal actualAmount;

    /**
    * 备注
    */
    private String chargeRemark;

    /**
    * 缴费时间
    */
    private Date chargePaymentDate;

    /**
    * 1为有效数据  0为错误数据
    */
    private Integer chargeStatus;
}