package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 房产表
    */
@Data
public class Home {
    /**
    * 房产id
    */
    private Integer homeId;

    /**
    * 外键，对应户主信息
    */
    private Integer ownerId;

    /**
    * 外键 栋数id
    */
    private Integer buildId;

    /**
    * 房产编号
    */
    private String homeNumbe;

    /**
    * 房产名称
    */
    private String homeName;

    /**
    * 房间数
    */
    private Integer homeRoom;

    /**
    * 房间单元
    */
    private Integer homeUnit;

    /**
    * 所在楼层数
    */
    private Integer homeLayer;

    /**
    * 房产描述
    */
    private String homeDescribe;

    /**
    * 房产入住时间
    */
    private Date homeCreateTime;

    /**
    * 0为正常,1为已删除数据
    */
    private Integer homeIsDelete;
}