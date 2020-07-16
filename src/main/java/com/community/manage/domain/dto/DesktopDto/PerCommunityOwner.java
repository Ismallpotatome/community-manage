package com.community.manage.domain.dto.DesktopDto;

import lombok.Data;

import java.io.Serializable;

/**
 * 每个小区对应的人数
 */
@Data
public class PerCommunityOwner implements Serializable {

    private String communityName;
    private Integer ownerCount;
}
