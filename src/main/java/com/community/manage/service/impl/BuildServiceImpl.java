package com.community.manage.service.impl;

import com.community.manage.domain.dto.BuildDto;
import com.community.manage.domain.entity.Build;
import com.community.manage.domain.entity.Community;
import com.community.manage.mapper.BuildDtoMapper;
import com.community.manage.mapper.BuildMapper;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.service.BuildService;
import com.community.manage.util.TwoResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class BuildServiceImpl implements BuildService {
    @Resource
    BuildMapper buildMapper;
    @Resource
    CommunityMapper communityMapper;
    @Resource
    BuildDtoMapper buildDtoMapper;
    @Override
    public TwoResult<List<BuildDto>> selectByKeyword(BuildDto buildDto) {
        int page = (buildDto.getPage() - 1) * buildDto.getSize();
        buildDto.setPage(page);
        List<BuildDto> buildDtos = buildDtoMapper.selectByKeyword(buildDto);
        TwoResult<List<BuildDto>> twoResult = new TwoResult<>();
        twoResult.setData(buildDtos);
        twoResult.setNumber(buildDtoMapper.selectMsgNumber(buildDto).getMsgNumber());
        return twoResult;
    }

    @Override
    public List<BuildDto> deleteOne(BuildDto buildDto) {
        int i = buildMapper.deleteOne(buildDto.getBuildId());
        if (i > 0) {
            return buildDtoMapper.selectByKeyword(buildDto);
        }
        return null;
    }

    @Override
    public List<BuildDto> deleteBatch(List<BuildDto> buildDtos) {
        ArrayList<Build> builds = new ArrayList<>();
       Build build = null;
        for (BuildDto dto : buildDtos) {
            build = new Build();
            BeanUtils.copyProperties(dto, build);
            builds.add(build);
        }
        int i = buildMapper.deleteAllBuild(builds);
        if (i > 0) {
            return buildDtoMapper.selectByKeyword(buildDtos.get(0));
        }
        return null;
    }

    @Override
    public String insertOne(BuildDto buildDto) {
        int i = haveName(buildDto.getCommunityName());
        if (i == -1) {
            return "插入失败,没有该小区";
        }
        Build build = new Build();
        BeanUtils.copyProperties(buildDto, build);
        build.setCommunityId(i);
        buildMapper.insertOne(build);
        return "插入成功";
    }

    @Override
    public List<BuildDto> updateOne(BuildDto buildDto) {
        int i = haveName(buildDto.getCommunityName());
        if (i == -1) {
            return null;
        }
        Build build = new Build();
        BeanUtils.copyProperties(buildDto, build);
        build.setCommunityId(i);
        buildMapper.updateOne(build);
        return  buildDtoMapper.selectByKeyword(buildDto);
    }

    //在全部小区中判断是否有该小区名字,有返回小区id,没有返回-1
    public int haveName(String name) {
        int communityId = -1;
        List<Community> communities = communityMapper.selectAllCommunity();
        for (Community community1 : communities) {
            if (name.equals(community1.getCommunityName())) {
                communityId = community1.getCommunityId();
                break;
            }
        }
        return communityId;
    }
}
