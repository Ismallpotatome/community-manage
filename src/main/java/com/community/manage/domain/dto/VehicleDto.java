package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VehicleDto implements Serializable {
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

    /**
     * 所属成员姓名
     */
    private String ownerName;
}
