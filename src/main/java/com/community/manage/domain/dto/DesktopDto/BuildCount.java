package com.community.manage.domain.dto.DesktopDto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BuildCount implements Serializable {
    /**
     * 小区所有楼栋总数
     */
    private Integer buildCount;
}
