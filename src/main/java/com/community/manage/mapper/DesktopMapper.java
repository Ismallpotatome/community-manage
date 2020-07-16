package com.community.manage.mapper;

import com.community.manage.domain.dto.DesktopDto.*;
import com.community.manage.domain.entity.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesktopMapper {

    BuildCount selectBuildCount();

    HomeCount selectHomeCount();

    OwnerCount selectOwnerCount();

    List<PerCommunityOwner> selectPerCommunityOwner();

    List<PerMonthComplaint> selectPerMonthComplaint();

    List<PerCommunityParking> selectPerCommunityParking();

    List<ActivityStatistics> selectActivityStatistics();

    List<WarrantyStatistics> selectWarrantyStatistics();

    Community selectIdByName(String communityName);
}
