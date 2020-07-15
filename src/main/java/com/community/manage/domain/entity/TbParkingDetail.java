package com.community.manage.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 各小区停车位使用情况
 */
@Data
public class TbParkingDetail {
    private Integer detailId;

    /**
     * 小区名字
     */
    private Integer communityId;

    /**
     * 外键字段，对应停车位表的id
     */
    private Integer userId;

    /**
     * 车牌号码
     */
    private String detailCarNum;

    /**
     * 车牌照片
     */
    private String detailImg;

    /**
     * 车辆所有人
     */
    private String detailUser;

    /**
     * 联系方式
     */
    private String detailPhone;

    /**
     * 1表示出售,0表示租用,
     */
    private Integer detailNature;

    /**
     * 价格
     */
    private BigDecimal detailPrice;

    /**
     * 开始时间
     */
    private Date detailBegin;

    /**
     * 截止时间
     */
    private Date detailOut;

    /**
     * 创建时间
     */
    private Date detailCreateTime;

    /**
     * 1表示存在,0表示删除
     */
    private Integer detailIsDel;
}