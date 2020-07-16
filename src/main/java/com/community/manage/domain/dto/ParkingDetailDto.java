package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbParkingDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ParkingDetailDto extends TbParkingDetail implements Serializable {
    /**
     * 小区名字
     */
    private String communityName;

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
     * 车位编号
     */
  private String userNumber;;

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
    @JsonFormat(pattern="yyyy-MM-dd ")
    private String detailBegin;

    /**
     * 截止时间
     */
    @JsonFormat(pattern="yyyy-MM-dd ")
    private String detailOut;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date detailCreateTime;

    /**
     * 1表示存在,0表示删除
     */
    private Integer detailIsDel;
}
