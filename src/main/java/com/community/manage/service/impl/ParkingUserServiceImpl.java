package com.community.manage.service.impl;



import com.community.manage.domain.dto.ParkingUseDto;
import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.mapper.TbParkingUserMapper;
import com.community.manage.service.ParkingUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingUserServiceImpl implements ParkingUserService {
    @Resource
    TbParkingUserMapper parkingUserMapper;

    @Override
    public List<TbParkingUser> selectAll(String keyword, String begin, String end, int limit, int offset) {
            limit = (limit-1)*offset;
            List<TbParkingUser> tbParkingUsers = parkingUserMapper.selectByCondition(keyword, begin, end, limit, offset);

            return tbParkingUsers;


    }


    @Override
    public int insert(ParkingUseDto parkingUserDto) {
        TbParkingUser parkingUser = new TbParkingUser();
        BeanUtils.copyProperties(parkingUserDto,parkingUser);
        int i = parkingUserMapper.insertParkingUser(parkingUser);
        return i;
    }

    @Override
    public int updateById(int status,int id) {
        return parkingUserMapper.updateByStatus(status,id);
    }

    @Override
    public int updateAll(ParkingUseDto parkingUseDto) {
        TbParkingUser parkingUser = new TbParkingUser();
        BeanUtils.copyProperties(parkingUseDto,parkingUser);
        return parkingUserMapper.updateAll(parkingUser);
    }

    @Override
    public int del(List<ParkingUseDto> list) {
        TbParkingUser parkingUse;
        int count = 0;
        for (ParkingUseDto parkingUseDto : list) {
            parkingUse = new TbParkingUser();
            BeanUtils.copyProperties(parkingUseDto,parkingUse);
            int i = parkingUserMapper.delById(parkingUse.getUserId());
            count +=i;
        }
        return count;
    }
}
