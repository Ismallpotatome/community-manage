package com.community.manage.service;

import com.community.manage.domain.dto.AdminDto;
import com.community.manage.domain.dto.OwnerDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface AdminsService {
    //管理员信息的关键字分页查询
    ResponseEntity personnelSearchByPage(SearchsDto searchDto);
    //添加"管理员"
    ResponseEntity addPersonnel(AdminDto adminDto);
    //批量删除"管理员"
    ResponseEntity deleteBatchPersonnel(List<Integer> personnelIdList);
    //修改"管理员"信息
    ResponseEntity personnelAlter(AdminDto adminDto);
    //删除单个"管理员"
    ResponseEntity deleteSinglePersonnel(Integer personnelId);
    //修改"管理员"状态
    ResponseEntity alterStatusPersonnel(Integer  personnelId);

    //获取全部"管理员角色"信息
    ResponseEntity getRoleAll();
}
