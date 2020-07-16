package com.community.manage.domain.dto;

import com.community.manage.domain.entity.Build;
import lombok.Data;

@Data
public class BuildDto extends Build {
    private String startDate;
    private String endDate = "2030-07-13 13:41:25";
    private int page = 1;
    private int size = 3;
    private String communityName;
    private int msgNumber;
}
