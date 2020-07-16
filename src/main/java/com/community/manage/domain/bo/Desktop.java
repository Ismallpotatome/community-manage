package com.community.manage.domain.bo;

import com.community.manage.domain.dto.DesktopDto.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回桌面对应展示的全部数据
 */
@Data
public class Desktop implements Serializable {
    /**
     * 小区总楼栋数
     */
    private BuildCount buildCount;

    /**
     * 小区总户数
     */
    private HomeCount homeCount;

    /**
     * 小区总人数
     */
    private OwnerCount ownerCount;

    /**
     * 每个小区对应的人数
     */
    private List<PerCommunityOwner> perCommunityOwners;

    /**
     * 每个小区对应停车位的数量
     */
    private List<PerCommunityParking> perCommunityParkings;

    /**
     * 每个月对应的投诉人数
     */
    private List<PerMonthComplaint> perMonthComplaints;

    /**
     * 部分活动的展示
     */
    private List<ActivityStatistics> activityStatistics;

    /**
     * 报修的情况
     */
    private List<WarrantyStatistics> warrantyStatistics;
}
