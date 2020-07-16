package com.community.manage.mapper.admins;

import com.community.manage.domain.dto.AdminRoleDto;
import com.community.manage.domain.entity.Admin;
import com.community.manage.domain.entity.AdminRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminsRoleMapper {
    //获取全部"管理员角色"的信息
    List<AdminRoleDto> selectAll();
    //添加"管理员角色"
    int insertRole(@Param("adminRole") AdminRole adminRole);
    //根据id批量修改数据状态
    int updateBatchRole(@Param("roleIdList") List<Integer> roleIdList);
    //修改信息
    int updateRole(@Param("adminRole") AdminRole adminRole);
    //根据id查询状态
    int selectStatusByRoleId(@Param("roleId") Integer roleId);
    //根据id修改状态为1,即删除
    int updateSingleRole(@Param("roleId") Integer roleId);
    //根据id修改状态为0,即启动
    int updateStatusStart(@Param("roleId") Integer roleId);
    //根据id修改状态为2,即禁用
    int updateStatusDisable(@Param("roleId") Integer roleId);
}
