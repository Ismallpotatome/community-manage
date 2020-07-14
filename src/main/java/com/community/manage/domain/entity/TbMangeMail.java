package com.community.manage.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 邮箱管理
    */
@Data
public class TbMangeMail {
    private Integer mailId;

    /**
    * 小区id
    */
    private Integer communityId;

    /**
    * 信件来源
    */
    private String mailSource;

    /**
    * 信件标题
    */
    private String mailTitle;

    /**
    * 创建时间
    */
    private Date mailCreateTime;

    /**
    * 0表示已读,1表示未读
    */
    private Integer mailStatus;

    /**
    * 0表示已删除,1表示未删除
    */
    private Integer mailIsDel;
}