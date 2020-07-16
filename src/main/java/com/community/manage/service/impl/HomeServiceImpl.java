package com.community.manage.service.impl;


import com.community.manage.domain.dto.HomeDto;
import com.community.manage.domain.entity.Build;
import com.community.manage.domain.entity.Community;
import com.community.manage.domain.entity.Home;
import com.community.manage.mapper.BuildMapper;
import com.community.manage.mapper.CommunityMapper;
import com.community.manage.mapper.HomeDtoMapper;
import com.community.manage.mapper.HomeMapper;
import com.community.manage.service.HomeService;
import com.community.manage.util.TwoResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    HomeMapper homeMapper;
    @Resource
    HomeDtoMapper homeDtoMapper;
    @Resource
    BuildMapper buildMapper;
    @Resource
    CommunityMapper communityMapper;
    @Override
    public TwoResult<List<HomeDto>> selectByKeyword(HomeDto homeDto) {
        int page = (homeDto.getPage() - 1) * homeDto.getSize();
        homeDto.setPage(page);
        List<HomeDto> homeDtos = homeDtoMapper.selectByKeyword(homeDto);
        TwoResult<List<HomeDto>> twoResult = new TwoResult<>();
        twoResult.setData(homeDtos);
        twoResult.setNumber(homeDtoMapper.selectHomeNumber(homeDto).getMsgNumber());
        return twoResult;
    }

    @Override
    public List<HomeDto> deleteBatch(List<HomeDto> homeDtos) {
        List<Home> homes = new ArrayList<>();
        BeanUtils.copyProperties(homeDtos, homes);
        int i = homeMapper.deleteBatch(homes);
        if (i > 0) {
            int page = (homeDtos.get(0).getPage() - 1) * homeDtos.get(0).getSize();
            homeDtos.get(0).setPage(page);
            return homeDtoMapper.selectByKeyword(homeDtos.get(0));
        }
        return null;
    }

    @Override
    public String addOne(HomeDto homeDto) {
        Community community = communityMapper.selectCommunityByName(homeDto.getCommunityName());
        Build build = buildMapper.selectByName(community.getCommunityId(), homeDto.getBuildName());
        Home home = new Home();
        BeanUtils.copyProperties(homeDto, home);
        home.setBuildId(build.getBuildId());
        return null;
    }

    @Override
    public String updateOne(HomeDto homeDto) {
        int buildId = -1;
        Home home = new Home();
        BeanUtils.copyProperties(homeDto, home);
        home.setBuildId(buildId);
        int i = homeMapper.updateOne(home);
        return "修改成功影响行数" + i;
    }

    @Override
    public List<HomeDto> deleteOne(HomeDto homeDto) {
        int i = homeMapper.deleteOne(homeDto.getHomeId());
        if (i > 0) {
            int page = (homeDto.getPage() - 1) * homeDto.getSize();
            homeDto.setPage(page);
            return homeDtoMapper.selectByKeyword(homeDto);
        }
        return null;
    }
}
