package com.community.manage.service.impl;
import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.domain.entity.Build;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.Home;
import com.community.manage.mapper.BuildMapper;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.CommunityDtoMapper;
import com.community.manage.mapper.HomeMapper;
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
    BuildMapper buildMapper;
    @Resource
    HomeMapper homeMapper;
    @Resource
    CommunityDtoMapper communityDtoMapper;
    @Override
    public List<CommunityDto> selectByFilter(CommunityDto filter) {
        int limit = (filter.getPage() - 1) * filter.getSize();
        filter.setPage(limit);
        List<CommunityDto> communityDtos = communityDtoMapper.selectFilter(filter);
        List<CommunityDto> list = new ArrayList<>();
        CommunityDto temp = new CommunityDto();
        for (Community community : communityDtos) {
            temp.setCommunityId(community.getCommunityId());
            CommunityDto dto = communityDtoMapper.selectSum(temp);
            temp.setCommunityHome(dto.getCommunityHome());
            BeanUtils.copyProperties(community, dto);
            dto.setCommunityHome(temp.getCommunityHome());
            list.add(dto);
        }
        return list;
    }

    @Override
    public String deleteOne(CommunityDto communityDto) {
        List<CommunityDto> communityDtos = null;
        int i = communityMapper.deleteOne(communityDto.getCommunityId());
        if (i > 0) {
            return  "删除成功";
        }
        return "删除失败";
    }

    @Override
    public String deleteBatch(List<CommunityDto> communityDtos) {
        ArrayList<Community> communities = new ArrayList<>();
        Community community = null;
        for (CommunityDto communityDto : communityDtos) {
            community = new Community();
            BeanUtils.copyProperties(communityDto, community);
            communities.add(community);
        }
        int batch = communityMapper.deleteBatch(communities);
        if (batch > 0) {
            return  "删除成功";
        }
        return "删除失败";
    }

    @Override
    public List<CommunityDto> updateOne(CommunityDto communityDto) {
        List<CommunityDto> dtos = null;
        int i = communityMapper.updateOne(communityDto);
        if (i > 0) {
            dtos = selectByFilter(communityDto);
        }
        return dtos;
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
    @Override
    public String updateStatus(int communityId, String status) {
        int tag = 0;
        String msg = "修改失败";
        if ("停用".equals(status)) {
           tag = communityMapper.updateStatus(communityId, 0);
           msg = "已停用";
        }
        if ("启用".equals(status)) {
           tag = communityMapper.updateStatus(communityId, 1);
           msg = "已启用";
        }
        if (tag > 0) {
            return msg;
        } else {
            return "修改失败";
        }
    }
    //根据小区Id查询出所有的房产
    public List<Home> selectHomeByCommunityId(int communityId) {
        List<Build> builds = buildMapper.selectAllBuildByCommunityId(communityId);
        List<Home> homes = homeMapper.selectAllHome(builds);
        return homes;
    }
    //根据小区Id查询出所有栋数
    public List<Build> selectBuildByCommunityId(int communityId) {
        List<Build> builds = buildMapper.selectAllBuildByCommunityId(communityId);
        return builds;
    }
    //根据小区Id查询出一条小区
    public Community selectOneCommunity(int communityId) {
       return communityMapper.selectOneCommunity(communityId);
    }
}
