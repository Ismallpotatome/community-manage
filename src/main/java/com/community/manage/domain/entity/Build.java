package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 楼栋表
    */
@Data
public class Build {
    /**
    * 栋数id
    */
    private Integer buildId;

    /**
    * 外键字段 小区id
    */
    private Integer communityId;

    /**
    * 栋数名称
    */
    private String bulidName;

    /**
    * 栋数编号
    */
    private String buildNumber;

    /**
    * 该栋用户数
    */
    private Integer buildHome;

    /**
    * 该栋描述
    */
    private String buildDescribe;

    /**
    * 该栋创建时间
    */
    private Date buildCreateTime;

    /**
    * 0为正常,1为已删除数据
    */
    private Integer buildIsDelete;
}