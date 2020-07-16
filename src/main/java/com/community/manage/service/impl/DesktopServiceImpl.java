package com.community.manage.service.impl;

import com.community.manage.domain.bo.Desktop;
import com.community.manage.domain.dto.DesktopDto.*;
import com.community.manage.mapper.DesktopMapper;
import com.community.manage.service.DesktopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DesktopServiceImpl implements DesktopService {
    @Resource
    DesktopMapper desktopMapper;

    @Override
    public Desktop packageDesktop() {
        Desktop desktop = new Desktop();
        //楼栋总数
        BuildCount buildCount = desktopMapper.selectBuildCount();
        desktop.setBuildCount(buildCount);
        //总户数
        HomeCount homeCount = desktopMapper.selectHomeCount();
        desktop.setHomeCount(homeCount);
        //总人数
        OwnerCount ownerCount = desktopMapper.selectOwnerCount();
        desktop.setOwnerCount(ownerCount);
        //每个小区人数
        List<PerCommunityOwner> perCommunityOwners = desktopMapper.selectPerCommunityOwner();
        desktop.setPerCommunityOwners(perCommunityOwners);
        //每个月投诉
        List<PerMonthComplaint> perMonthComplaints = desktopMapper.selectPerMonthComplaint();
        desktop.setPerMonthComplaints(perMonthComplaints);
        //每个小区停车位
        List<PerCommunityParking> perCommunityParkings = desktopMapper.selectPerCommunityParking();
        desktop.setPerCommunityParkings(perCommunityParkings);
        //最近活动名
        List<ActivityStatistics> activityStatistics = desktopMapper.selectActivityStatistics();
        desktop.setActivityStatistics(activityStatistics);
        //最近的报修
        List<WarrantyStatistics> warrantyStatistics = desktopMapper.selectWarrantyStatistics();
        desktop.setWarrantyStatistics(warrantyStatistics);
        return desktop;
    }
}
