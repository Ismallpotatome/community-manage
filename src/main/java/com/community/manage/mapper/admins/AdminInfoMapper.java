package com.community.manage.mapper.admins;

import com.community.manage.domain.dto.AdminDto;
import com.community.manage.domain.dto.OwnerDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.Admin;
import com.community.manage.domain.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminInfoMapper {
    //根据关键字和时间进行分页查询
    List<AdminDto> selectBySearchAndLimit(@Param("searchDto") SearchsDto searchDto);
    //添加"管理员"
    int insertPersonnel(@Param("admin") Admin admin);
    //根据id批量修改数据状态
    int updateBatchPersonnel(@Param("personnelIdList") List<Integer> personnelIdList);
    //修改信息
    int updatePersonnel(@Param("admin") Admin admin);
    //根据id查询状态
    int selectStatusByPersonnelId(@Param("personnelId") Integer personnelId);
    //根据id修改状态为1,即删除
    int updateSinglePersonnel(@Param("personnelId") Integer personnelId);
    //根据id修改状态为0,即启动
    int updateStatusStart(@Param("personnelId") Integer personnelId);
    //根据id修改状态为2,即禁用
    int updateStatusDisable(@Param("personnelId") Integer personnelId);

}
