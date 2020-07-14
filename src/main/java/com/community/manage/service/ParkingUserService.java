package com.community.manage.service;



import com.community.manage.domain.entity.TbParkingUser;


import java.util.List;

public interface ParkingUserService {
    List<TbParkingUser> selectAll( String keyword,  String begin,  String end, int limit, int offset);


    int insert(TbParkingUser parkingUser);

    int updateById(int status,int id);

    public int updateAll(int comId,String username,int status,int userId);

    int del(List<Integer> list);


}
