package com.community.manage.domain.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchDto implements Serializable {
    /**
     * 搜索关键字
     */
    private String keywords;
    /**
     * 时间段搜索开始时间
     */
    private Date startTime;
    /**
     * 时间段搜索结束时间
     */
    private Date endTime;
}
