package com.community.manage.domain.dto.DesktopDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ActivityStatistics implements Serializable {
    /**
     * 小区活动名称
     */
    private String activityTittle;

    /**
     * 建立时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp activityCreateTime;
}
