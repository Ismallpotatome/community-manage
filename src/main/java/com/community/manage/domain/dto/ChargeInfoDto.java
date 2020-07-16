package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChargeInfoDto implements Serializable {
    /**
     * 收费项目id
     */
    private Integer chargeId;

    /**
     * 收费名称
     */
    private String chargeName;

    /**
     * 小区名称
     */
    private String communityName;
}
