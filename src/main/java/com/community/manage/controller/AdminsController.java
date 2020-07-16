package com.community.manage.controller;

import com.community.manage.domain.dto.AdminDto;
import com.community.manage.domain.dto.OwnerDto;
import com.community.manage.domain.dto.SearchsDto;
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
}
