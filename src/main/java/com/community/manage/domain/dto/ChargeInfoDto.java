package com.community.manage.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
