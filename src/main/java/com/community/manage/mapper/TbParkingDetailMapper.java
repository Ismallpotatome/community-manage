package com.community.manage.mapper;

import com.community.manage.domain.entity.TbParkingDetail;
import com.community.manage.domain.entity.TbParkingUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbParkingDetailMapper {

    /**
     * 这是对应网页的条件查询搜索框
     *
     * @param keyword 第三个输入框导入的String
     * @param begin   开始的时间 第一个输入框
     * @param end     结束的时间 第二个输入框
     * @param limit   分页
     * @param offset  分页
     * @return
     */
    List<TbParkingDetail> selectByCondition(@Param("keyword") String keyword, @Param("begin") String begin, @Param("end") String end, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 这里是添加 需要输入外键id,车位名称,车位编号
     *
     * @param detail 需要插入的对象
     * @return
     */
    int insertParkingDetail(@Param("detail") TbParkingDetail detail);


    /**
     * 这里对应修改尾部修改按钮
     *
     * @param detail
     * @return
     */
    int updateAll(@Param("detail") TbParkingDetail detail);

    /**
     * 这里对应尾部的删除按钮
     *
     * @param detailId
     * @return
     */
    int delById(@Param("detailId") int detailId);
}