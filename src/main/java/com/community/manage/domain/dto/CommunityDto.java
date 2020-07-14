package com.community.manage.domain.dto;

import com.community.manage.domain.entity.Community;
import lombok.Data;

@Data
public class CommunityDto extends  Community {
    private Integer communityHomeNumber;
    private String  startDate;
    private String endDate;
    private int page = 1;
    private int size = 3;
}
