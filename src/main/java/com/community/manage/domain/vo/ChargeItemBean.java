package com.community.manage.domain.vo;

import com.community.manage.domain.entity.Charge;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ChargeItemBean implements Serializable {
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

    /**
     * 一一对应的Charge
     */
    private ChargeBean chargeBean;
}
