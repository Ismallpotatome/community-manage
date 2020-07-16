package com.community.manage.mapper;

import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbParkingDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMangeActivityMapper {

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
    List<TbMangeActivity> selectByCondition(@Param("keyword") String keyword, @Param("begin") String begin, @Param("end") String end, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 这里是添加
     *
     * @param mangeActivity 需要插入的对象
     * @return
     */
    int insertMangeActivity(@Param("mangeActivity") TbMangeActivity mangeActivity);

    /**
     * 这里对应修改尾部修改按钮
     *
     * @param mangeActivity
     * @return
     */
    int updateAll(@Param("mangeActivity") TbMangeActivity mangeActivity);

    /**
     * 这里对应尾部的删除按钮
     *
     * @param activityId
     * @return
     */
    int delById(@Param("activityId") int activityId);
}