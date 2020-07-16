package com.community.manage.mapper.admins;

import com.community.manage.domain.dto.PermissionsDto;
import com.community.manage.domain.entity.AdminRole;
import com.community.manage.domain.entity.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionsMapper {
    //获取全部"管理员角色"的信息
    List<PermissionsDto> selectAll();
    //添加"权限"
    int insertPermissions(@Param("permissions") Permissions permissions);
    //根据id批量修改数据状态
    int updateBatchPermissions(@Param("permissionsIdList") List<Integer> permissionsIdList);
    //修改信息
    int updatePermissions(@Param("permissions") Permissions permissions);
    //根据id查询状态
    int selectStatusByPermissionsId(@Param("permissionsId") Integer permissionsId);
    //根据id修改状态为1,即删除
    int updateSinglePermissions(@Param("permissionsId") Integer permissionsId);
    //根据id修改状态为0,即启动
    int updateStatusStart(@Param("permissionsId") Integer permissionsId);
    //根据id修改状态为2,即禁用
    int updateStatusDisable(@Param("permissionsId") Integer permissionsId);
}
