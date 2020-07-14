package com.community.manage.service.Impl;



import com.community.manage.domain.entity.TbParkingUser;
import com.community.manage.mapper.TbParkingUserMapper;
import com.community.manage.service.ParkingUserService;
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
        if(Integer.parseInt(end)>Integer.parseInt(begin)) {


            List<TbParkingUser> tbParkingUsers = parkingUserMapper.selectByCondition(keyword, begin, end, limit, offset);

            return tbParkingUsers;
        }else
        {
            return null;
        }

    }


    @Override
    public int insert(TbParkingUser parkingUser) {
        int i = parkingUserMapper.insertParkingUser(parkingUser);
        return i;
    }

    @Override
    public int updateById(int status,int id) {
        return parkingUserMapper.updateByStatus(status,id);
    }

    @Override
    public int updateAll(int comId, String username, int status, int userId) {
        TbParkingUser parkingUser = new TbParkingUser();
        parkingUser.setUserName(username);
        parkingUser.setUserCommunity(comId);
        parkingUser.setUserStatus(status);
        parkingUser.setUserId(userId);
        return parkingUserMapper.updateAll(parkingUser);
    }

    @Override
    public int del(List<Integer> list) {
        int count = 0;
        for (Integer integer : list) {
            int i = parkingUserMapper.delById(integer);
            count +=1;
        }
        return count;
    }
}
