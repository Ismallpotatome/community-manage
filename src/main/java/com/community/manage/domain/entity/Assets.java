package com.community.manage.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
    * 小区的设备资产表
    */
@Data
public class Assets {
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
    private Date assetsEstablishDate;

    /**
    * 1表示可用，0表示删除
    */
    private Integer assetsStatus;
}