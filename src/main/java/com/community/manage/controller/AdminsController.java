package com.community.manage.controller;

import com.community.manage.domain.dto.*;
import com.community.manage.service.AdminsService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("admins")
public class AdminsController {
    @Resource
    AdminsService adminsService;
    /**
     * 根据关键字和时间进行分页搜索
     * @param searchDto
     * @return
     */
    @PostMapping("personnel/search")
    public ResponseEntity personnelSearch(@RequestBody SearchsDto searchDto) {
        return adminsService.personnelSearchByPage(searchDto);
    }

    /**
     * 添加管理员
     * @param adminDto:管理员信息的封装类
     * @return
     */
    @PostMapping("personnel/add")
    public ResponseEntity personnelAdd(@RequestBody AdminDto adminDto){
        return  adminsService.addPersonnel(adminDto);
    }

    /**
     * 批量删除管理员
     * @param personnelIdList:需批量删除的id集合
     * @return
     */
    @PostMapping("personnel/delete_batch")
    public ResponseEntity personnelBatchDelete(@RequestBody List<Integer> personnelIdList){
        return adminsService.deleteBatchPersonnel(personnelIdList);
    }

    /**
     * 修改"管理员"信息
     * @param adminDto:需要修改的管理员id
     * @return
     */
    @PostMapping("personnel/alter")
    public ResponseEntity personnelAlter(@RequestBody AdminDto adminDto){
        return adminsService.personnelAlter(adminDto);
    }

    /**
     * 删除单个管理员
     * @param personnelId
     * @return
     */
    @PostMapping("personnel/delete_single")
    public ResponseEntity personnelSingleDelete(@RequestBody Integer personnelId){
        return adminsService.deleteSinglePersonnel(personnelId);
    }

    /**
     * 修改"管理员"的状态
     * @param personnelId
     * @return
     */
    @PostMapping("personnel/status_alter")
    public ResponseEntity personnelStatusAlter(@RequestBody Integer personnelId){
        return adminsService.alterStatusPersonnel(personnelId);
    }
    /**
     * 获取全部的管理员角色信息
     * @return
     */
    @GetMapping("role/get_all")
    public ResponseEntity getAdminRoleAll(){
        return adminsService.getRoleAll();
    }

    /**
     * 添加管理员角色
     * @param adminRoleDto:管理员角色信息的封装类
     * @return
     */
    @PostMapping("role/add")
    public ResponseEntity roleAdd(@RequestBody AdminRoleDto adminRoleDto){
        return  adminsService.addRole(adminRoleDto);
    }

    /**
     * 批量删除管理员角色
     * @param roleIdList:需批量删除的id集合
     * @return
     */
    @PostMapping("role/delete_batch")
    public ResponseEntity roleBatchDelete(@RequestBody List<Integer> roleIdList){
        return adminsService.deleteBatchRole(roleIdList);
    }

    /**
     * 修改"管理员角色"信息
     * @param adminRoleDto:需要修改的管理员角色id
     * @return
     */
    @PostMapping("role/alter")
    public ResponseEntity roleAlter(@RequestBody AdminRoleDto adminRoleDto){
        return adminsService.RoleAlter(adminRoleDto);
    }

    /**
     * 删除单个管理员角色
     * @param roleId
     * @return
     */
    @PostMapping("role/delete_single")
    public ResponseEntity roleSingleDelete(@RequestBody Integer roleId){
        return adminsService.deleteSingleRole(roleId);
    }

    /**
     * 修改"管理员角色"的状态
     * @param roleId
     * @return
     */
    @PostMapping("role/status_alter")
    public ResponseEntity roleStatusAlter(@RequestBody Integer roleId){
        return adminsService.alterStatusRole(roleId);
    }

    /**
     * 获取全部的权限信息
     * @return
     */
    @GetMapping("permissions/get_all")
    public ResponseEntity getPermissionsAll(){
        return adminsService.getPermissionsAll();
    }

    /**
     * 添加权限
     * @param permissionsDto:权限信息的封装类
     * @return
     */
    @PostMapping("permissions/add")
    public ResponseEntity permissionsAdd(@RequestBody PermissionsDto permissionsDto){
        return adminsService.addPermissions(permissionsDto);
    }

    /**
     * 批量删除权限
     * @param permissionsIdList:需批量删除的id集合
     * @return
     */
    @PostMapping("permissions/delete_batch")
    public ResponseEntity permissionsBatchDelete(@RequestBody List<Integer> permissionsIdList){
        return adminsService.deleteBatchPermissions(permissionsIdList);
    }

    /**
     * 修改"权限"信息
     * @param permissionsDto:需要修改的权限id
     * @return
     */
    @PostMapping("permissions/alter")
    public ResponseEntity permissionsAlter(@RequestBody PermissionsDto permissionsDto){
        return adminsService.PermissionsAlter(permissionsDto);
    }

    /**
     * 删除单个权限
     * @param permissionsId
     * @return
     */
    @PostMapping("permissions/delete_single")
    public ResponseEntity permissionsSingleDelete(@RequestBody Integer permissionsId){
        return adminsService.deleteSinglePermissions(permissionsId);
    }

    /**
     * 修改"权限"的状态
     * @param permissionsId
     * @return
     */
    @PostMapping("permissions/status_alter")
    public ResponseEntity permissionsStatusAlter(@RequestBody Integer permissionsId){
        return adminsService.alterStatusPermissions(permissionsId);
    }

}
