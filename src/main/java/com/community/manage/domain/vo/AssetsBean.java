package com.community.manage.domain.vo;

import com.community.manage.domain.entity.Community;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class AssetsBean implements Serializable {
    /**
     * 资产表主键
     */
    private Integer assetsId;

    /**
     * 外键字段，对应小区表的主键
     */
    private Integer communityId;

    /**
     * 设备编号
     */
    private String assetsNum;

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

    /**
     * 1表示可用，0表示删除
     */
    private Integer assetsStatus;
    /**
     * 关联的小区信息
     */
    private Community community;
}
