package com.community.manage.service;

import com.community.manage.domain.dto.*;
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
    //添加"管理员角色"
    ResponseEntity addRole(AdminRoleDto adminRoleDto);
    //批量删除"管理员角色"
    ResponseEntity deleteBatchRole(List<Integer> roleIdList);
    //修改"管理员角色"信息
    ResponseEntity RoleAlter(AdminRoleDto adminRoleDto);
    //删除单个"管理员角色"
    ResponseEntity deleteSingleRole(Integer roleId);
    //修改"管理员角色"状态
    ResponseEntity alterStatusRole(Integer  roleId);

    //获取全部"权限"信息
    ResponseEntity getPermissionsAll();
    //添加"权限"
    ResponseEntity addPermissions(PermissionsDto permissionsDto);
    //批量删除"权限"
    ResponseEntity deleteBatchPermissions(List<Integer> permissionsIdList);
    //修改"权限"信息
    ResponseEntity PermissionsAlter(PermissionsDto permissionsDto);
    //删除单个"权限"
    ResponseEntity deleteSinglePermissions(Integer permissionsId);
    //修改"权限"状态
    ResponseEntity alterStatusPermissions(Integer  permissionsId);
}
