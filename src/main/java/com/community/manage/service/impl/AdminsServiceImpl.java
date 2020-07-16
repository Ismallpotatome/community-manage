package com.community.manage.service.impl;

import com.community.manage.domain.dto.AdminDto;
import com.community.manage.domain.dto.AdminRoleDto;
import com.community.manage.domain.dto.PermissionsDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Admin;
import com.community.manage.domain.entity.AdminRole;
import com.community.manage.domain.entity.Permissions;
import com.community.manage.mapper.admins.AdminInfoMapper;
import com.community.manage.mapper.admins.AdminPermissionsMapper;
import com.community.manage.mapper.admins.AdminsRoleMapper;
import com.community.manage.service.AdminsService;
import com.community.manage.util.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AdminsServiceImpl implements AdminsService {
    @Resource
    AdminInfoMapper adminInfoMapper;
    @Resource
    AdminsRoleMapper adminsRoleMapper;
    @Resource
    AdminPermissionsMapper adminPermissionsMapper;

    /**
     * 分页处理
     *
     * @return
     */
    public void pageDispose(SearchsDto searchDto) {
        //检测page是否为空
        if (searchDto.getPage() == 0) {
            searchDto.setPage(1);
        }
        //检测size是否为空
        if (searchDto.getSize() == 0) {
            searchDto.setSize(5);
        }
        //查询的起始
        int limit = (searchDto.getPage() - 1) * searchDto.getSize();
        searchDto.setPage(limit);
    }

    /**
     * 根据关键字和时间进行分页搜索
     *
     * @param searchDto
     * @return
     */
    @Override
    public ResponseEntity personnelSearchByPage(SearchsDto searchDto) {

        pageDispose(searchDto);
        List<AdminDto> adminDtos = adminInfoMapper.selectBySearchAndLimit(searchDto);
        return ResponseEntity.success(adminDtos);
    }

    /**
     * 添加管理员
     *
     * @param adminDto
     * @return
     */
    @Override
    public ResponseEntity addPersonnel(AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        int i = adminInfoMapper.insertPersonnel(admin);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 批量删除"管理员"
     *
     * @param personnelIdList
     * @return
     */
    @Override
    public ResponseEntity deleteBatchPersonnel(List<Integer> personnelIdList) {
        int i = adminInfoMapper.updateBatchPersonnel(personnelIdList);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"管理员"信息
     *
     * @param adminDto:管理员信息封装类
     * @return
     */
    @Override
    public ResponseEntity personnelAlter(AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        int i = adminInfoMapper.updatePersonnel(admin);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 删除单个管理员
     *
     * @param personnelId
     * @return
     */
    @Override
    public ResponseEntity deleteSinglePersonnel(Integer personnelId) {
        int i = adminInfoMapper.updateSinglePersonnel(personnelId);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"管理员"的状态
     *
     * @param personnelId
     * @return
     */
    @Override
    public ResponseEntity alterStatusPersonnel(Integer personnelId) {
        //操作状态修改返回的结果
        int result;
        //查询该管理员的当前状态
        int status = adminInfoMapper.selectStatusByPersonnelId(personnelId);
        //如果该管理员的当前状态为0,即"启动"状态
        if (status == 0) {
            //则修改为"禁用"状态
            result = adminInfoMapper.updateStatusDisable(personnelId);
        } else {
            //否则修改为"启动"状态
            result = adminInfoMapper.updateStatusStart(personnelId);
        }
        //对状态修改返回的结果进行判断
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 获取全部的管理员角色的信息
     *
     * @return
     */
    @Override
    public ResponseEntity getRoleAll() {
        List<AdminRoleDto> adminRoleDtos = adminsRoleMapper.selectAll();
        return ResponseEntity.success(adminRoleDtos);
    }

    /**
     * 添加"管理员角色"
     *
     * @param adminRoleDto
     * @return
     */
    @Override
    public ResponseEntity addRole(AdminRoleDto adminRoleDto) {
        AdminRole adminRole = new AdminRole();
        BeanUtils.copyProperties(adminRoleDto, adminRole);
        int i = adminsRoleMapper.insertRole(adminRole);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 批量删除"管理员角色"
     *
     * @param roleIdList
     * @return
     */
    @Override
    public ResponseEntity deleteBatchRole(List<Integer> roleIdList) {
        int i = adminsRoleMapper.updateBatchRole(roleIdList);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"管理员角色"
     *
     * @param adminRoleDto
     * @return
     */
    @Override
    public ResponseEntity RoleAlter(AdminRoleDto adminRoleDto) {
        AdminRole adminRole = new AdminRole();
        BeanUtils.copyProperties(adminRoleDto, adminRole);
        int i = adminsRoleMapper.updateRole(adminRole);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 删除单个"管理员角色"
     *
     * @param roleId
     * @return
     */
    @Override
    public ResponseEntity deleteSingleRole(Integer roleId) {
        int i = adminsRoleMapper.updateSingleRole(roleId);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"管理员角色"的状态
     *
     * @param roleId
     * @return
     */
    @Override
    public ResponseEntity alterStatusRole(Integer roleId) {
        //操作状态修改返回的结果
        int result;
        //查询该管理员的当前状态
        int status = adminsRoleMapper.selectStatusByRoleId(roleId);
        //如果该管理员的当前状态为0,即"启动"状态
        if (status == 0) {
            //则修改为"禁用"状态
            result = adminsRoleMapper.updateStatusDisable(roleId);
        } else {
            //否则修改为"启动"状态
            result = adminsRoleMapper.updateStatusStart(roleId);
        }
        //对状态修改返回的结果进行判断
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 获取全部"权限"信息
     *
     * @return
     */
    @Override
    public ResponseEntity getPermissionsAll() {
        List<PermissionsDto> permissionsDtos = adminPermissionsMapper.selectAll();
        return ResponseEntity.success(permissionsDtos);
    }

    /**
     * 添加"权限"
     *
     * @param permissionsDto
     * @return
     */
    @Override
    public ResponseEntity addPermissions(PermissionsDto permissionsDto) {
        Permissions permissions = new Permissions();
        BeanUtils.copyProperties(permissionsDto, permissions);
        int i = adminPermissionsMapper.insertPermissions(permissions);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 批量删除"权限"
     *
     * @param permissionsIdList
     * @return
     */
    @Override
    public ResponseEntity deleteBatchPermissions(List<Integer> permissionsIdList) {
        int i = adminPermissionsMapper.updateBatchPermissions(permissionsIdList);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"权限"
     *
     * @param permissionsDto
     * @return
     */
    @Override
    public ResponseEntity PermissionsAlter(PermissionsDto permissionsDto) {
        Permissions permissions = new Permissions();
        BeanUtils.copyProperties(permissionsDto, permissions);
        int i = adminPermissionsMapper.updatePermissions(permissions);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 删除单个"权限"
     *
     * @param permissionsId
     * @return
     */
    @Override
    public ResponseEntity deleteSinglePermissions(Integer permissionsId) {
        int i = adminPermissionsMapper.updateSinglePermissions(permissionsId);
        if (i > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }

    /**
     * 修改"权限"的"状态"
     *
     * @param permissionsId
     * @return
     */
    @Override
    public ResponseEntity alterStatusPermissions(Integer permissionsId) {
        //操作状态修改返回的结果
        int result;
        //查询该管理员的当前状态
        int status = adminPermissionsMapper.selectStatusByPermissionsId(permissionsId);
        //如果该管理员的当前状态为0,即"启动"状态
        if (status == 0) {
            //则修改为"禁用"状态
            result = adminPermissionsMapper.updateStatusDisable(permissionsId);
        } else {
            //否则修改为"启动"状态
            result = adminPermissionsMapper.updateStatusStart(permissionsId);
        }
        //对状态修改返回的结果进行判断
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error();
        }
    }
}
