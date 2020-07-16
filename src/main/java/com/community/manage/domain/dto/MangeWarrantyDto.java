package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbMangeWarranty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MangeWarrantyDto extends TbMangeWarranty implements Serializable {
    private Integer warrantyId;

    /**
     * 小区id
     */
    private Integer communityId;
    /**
     * 小区名字
     */
    private String communityName;

    /**
     * 报修人员
     */
    private String warrantyUse;

    /**
     * 设备名称
     */
    private String warrantyEquipment;

    /**
     * 报修描述
     */
    private String warrantyDescribe;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date warrantyCreateTime;

    /**
     * 0表示待处理,1表示已处理
     */
    private Integer warrantyStatus;

    /**
     * 0表示已删除,1表示未删除
     */
    private Integer warrantyIsDel;

}
