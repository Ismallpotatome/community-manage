package com.community.manage.mapper;


import com.community.manage.domain.entity.TbParkingUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TbParkingUserMapper {

    TbParkingUser selectByNum(@Param("userNum") String userNum);

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
    List<TbParkingUser> selectByCondition(@Param("keyword") String keyword, @Param("begin") String begin, @Param("end") String end, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 这里是添加 需要输入外键id,车位名称,车位编号
     *
     * @param user 需要插入的对象
     * @return
     */
    int insertParkingUser(@Param("user") TbParkingUser user);

    /**
     * 这里是通过点击修改状态的函数
     *
     * @param status
     * @return
     */
    int updateByStatus(@Param("status") int status, @Param("id") int id);

    /**
     * 这里对应修改尾部修改按钮
     *
     * @param user
     * @return
     */
    int updateAll(@Param("user") TbParkingUser user);

    /**
     * 这里对应尾部的删除按钮
     *
     * @param userId
     * @return
     */
    int delById(@Param("userId") int userId);
}