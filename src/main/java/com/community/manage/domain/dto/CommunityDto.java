package com.community.manage.domain.dto;

import com.community.manage.domain.entity.Community;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CommunityDto extends  Community {
    private String startDate;
    private String endDate = "2030-07-13 13:41:25";
    private int page = 1;
    private int size = 3;
    private int allBuildNumber;
    private int allHomeNumber;
    private int msgNumber;
    private String communityCreatEtime;
}
