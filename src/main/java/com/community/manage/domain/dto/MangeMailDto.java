package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbMangeMail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MangeMailDto extends TbMangeMail implements Serializable {

    private Integer mailId;
    /**
     * 小区id
     */
    private Integer communityId;
    /**
     * 小区名字
     */
    private String communityName;


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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
