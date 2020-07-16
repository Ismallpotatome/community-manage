package com.community.manage.domain.dto.DesktopDto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WarrantyStatistics implements Serializable {
    /**
     * 报修设备名称
     */
    private String warrantyEquipment;

    /**
     * 创建时间
     */
    private Date warrantyCreateTime;

    /**
     * 0表示待处理,1表示已处理
     */
    private Integer warrantyStatus;
}
