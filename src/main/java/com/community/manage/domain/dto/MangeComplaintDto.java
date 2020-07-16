package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbMangeComplaint;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MangeComplaintDto extends TbMangeComplaint implements Serializable {
    private Integer complaintId;
    /**
     * 小区id
     */
    private Integer communityId;
    /**
     * 小区名字
     */
    private String communityName;


    /**
     * 投诉人员
     */
    private String complaintUse;

    /**
     * 投诉原因
     */
    private String complaintReason;

    /**
     * 投诉原因描述
     */
    private String complaintDescribe;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date complaintCreateTime;

    /**
     * 0表示不匿名,1表示匿名
     */
    private Integer complaintStatus;

    /**
     * 0表示已删除,1表示未删除
     */
    private Integer complaintIsDel;
}
