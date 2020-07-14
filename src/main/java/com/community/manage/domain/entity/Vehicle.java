package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 车辆管理表
    */
@Data
public class Vehicle {
    /**
    * 车辆id
    */
    private Integer vehicleId;

    /**
    * 所属成员id,外键(成员)
    */
    private Integer vehicleOwnerId;

    /**
    * 车牌号码
    */
    private String vehicleNumber;

    /**
    * 车辆颜色
    */
    private String vehicleColor;

    /**
    * 车辆照片
    */
    private String vehiclePhoto;

    /**
    * 描述
    */
    private String vehicleDescribe;

    /**
    * 创建时间
    */
    private Date vehicleCreatetime;

    /**
    * 更新时间
    */
    private Date vehicleUpdatetime;

    /**
    * 状态,1:已删除,0:未删除
    */
    private Integer vehicleStatus;
}