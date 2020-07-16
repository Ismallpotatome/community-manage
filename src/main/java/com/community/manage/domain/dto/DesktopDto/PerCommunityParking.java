package com.community.manage.domain.dto.DesktopDto;

import lombok.Data;

import java.io.Serializable;

/**
 * 每个小区停车位的数量
 */
@Data
public class PerCommunityParking implements Serializable {
    private String communityName;
    private Integer parkingCount;
}
