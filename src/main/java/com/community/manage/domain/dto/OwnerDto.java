package com.community.manage.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OwnerDto implements Serializable {
    /**
     * 业主人员id
     */
    private Integer ownerId;
    /**
     * 成员名称
     */
    private String ownerName;
}
