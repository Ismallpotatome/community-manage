package com.community.manage.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 接收前端传输的参数
 */
@Data
public class AssetsInfoDto implements Serializable {
    /**
     * 资产表主键
     */
    private Integer assetsId;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 设备名称
     */
    private String assetsName;

    /**
     * 设备的品牌
     */
    private String assetsBrand;

    /**
     * 设备购买单价
     */
    private BigDecimal assetsPurchasePrice;

    /**
     * 设备购买数量
     */
    private Integer assetsPurchaseQuantity;

    /**
     * 使用寿命
     */
    private Integer assetsLife;

    /**
     * 建立时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp assetsEstablishDate;
}
