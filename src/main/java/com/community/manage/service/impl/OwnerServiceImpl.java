package com.community.manage.service.impl;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.VehicleDto;
import com.community.manage.domain.entity.Owner;
import com.community.manage.mapper.owner.OwnerVehicleMapper;
import com.community.manage.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    OwnerVehicleMapper ownerVehicleMapper;

    @Override
    public List<Owner> personnelSearchByPage(SearchDto searchDto) {

        return null;
    }

    /**
     * 根据关键字和时间对车辆信息进行分页查询
     * @param searchDto:搜索的信息
     * @return List<VehicleDto>:查询到的"车辆"信息集合
     */
    @Override
    public List<VehicleDto> vehicleSearchByPage(SearchDto searchDto) {
        //查询的起始
        int limit = (searchDto.getPage() - 1) * searchDto.getSize();
        searchDto.setPage(limit);
        return ownerVehicleMapper.selectBySearchAndLimit(searchDto);
    }
}
