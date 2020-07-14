package com.community.manage.service.impl;
import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.domain.entity.Community;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.CommunityDtoMapper;
import com.community.manage.service.CommunityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Resource
    CommunityMapper communityMapper;
    @Resource
    CommunityDtoMapper communityDtoMapper;
    @Override
    public List<CommunityDto> selectByFilter(CommunityDto filter) {
        int limit = (filter.getPage() - 1) * filter.getSize();
        List<Community> communitys = communityMapper.selectFilter(filter.getStartDate(), filter.getEndDate(), limit, filter.getSize());
        List<CommunityDto> communityDtos = communityDtoMapper.selectSum(filter.getStartDate(), filter.getEndDate(), limit, filter.getSize());
        for (int i = 0; i < communityDtos.size(); i++) {
            BeanUtils.copyProperties(communitys.get(i), communityDtos.get(i));
        }
        return communityDtos;
    }

    @Override
    public String deleteOne(int communityId) {
        String str = "删除失败";
        int i = communityMapper.deleteOne(communityId);
        if (i > 0) {
            str = "删除成功";
        }
        return str;
    }

    @Override
    public String deleteBatch(List<CommunityDto> communityDtos) {
        String str = "排量删除失败";
        ArrayList<Community> communities = new ArrayList<>();
        Community community = new Community();
        for (CommunityDto communityDto : communityDtos) {
            BeanUtils.copyProperties(communityDto, community);
            communities.add(community);
        }
        int batch = communityMapper.deleteBatch(communities);
        if (batch > 0) {
            str = "批量删除成功";
        }
        return str;
    }

    @Override
    public String updateOne(CommunityDto communityDto) {
        String str = "更新失败";
        Community community = new Community();
        BeanUtils.copyProperties(communityDto, community);
        int i = communityMapper.updateOne(community);
        if (i > 0) {
            str = "跟新成功";
        }
        return str;
    }

    @Override
    public String insertOne(CommunityDto communityDto) {
        String str = "插入失败";
        Community community = new Community();
        BeanUtils.copyProperties(communityDto, community);
        int i = communityMapper.insertOne(community);
        if (i > 0) {
            str = "插入成功";
        }
        return str;
    }
}
