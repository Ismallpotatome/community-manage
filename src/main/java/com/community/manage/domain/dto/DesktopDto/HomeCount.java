package com.community.manage.domain.dto.DesktopDto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HomeCount  implements Serializable {
    /**
     * 小区总户数
     */
    private Integer homeCount;
}
