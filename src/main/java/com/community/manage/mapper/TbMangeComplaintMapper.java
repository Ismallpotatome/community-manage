package com.community.manage.mapper;

import com.community.manage.domain.entity.TbMangeComplaint;

public interface TbMangeComplaintMapper {
    int deleteByPrimaryKey(Integer complaintId);

    int insert(TbMangeComplaint record);

    int insertSelective(TbMangeComplaint record);

    TbMangeComplaint selectByPrimaryKey(Integer complaintId);

    int updateByPrimaryKeySelective(TbMangeComplaint record);

    int updateByPrimaryKey(TbMangeComplaint record);
}