package com.community.manage.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ChargeItemInfoDto implements Serializable {

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 收费名称
     */
    private String chargeName;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chargePaymentDate;

}
