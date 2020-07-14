package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 小区现有停车位
    */
@Data
public class TbParkingUser {
    private Integer userId;

    /**
    * 小区名字
    */
    private String userCommunity;

    /**
    * 车位编号
    */
    private String userNumber;

    /**
    * 车位名称
    */
    private String userName;

    /**
    * 创建时间
    */
    private Date userCreateTime;

    /**
    * 1表示使用,0表示闲置中
    */
    private Integer userStatus;

    /**
    * 1表示使用,0表示已经删除
    */
    private Integer userIsDel;
}