package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbParkingUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ParkingUseDto extends TbParkingUser  implements Serializable {
    List<ParkingUseDto> list;

    private Integer userId;

    /**
     * 小区名字
     */
    private Integer communityId;
    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 车位编号
     */
    private String userNumber;

    /**
     * 车位名称
     */
    private String userName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date userCreateTime;

    /**
     * 1表示使用,0表示闲置中
     */
    private Integer userStatus;

    /**
     * 1表示使用,0表示已经删除
     */
    private Integer userIsDel;

}
