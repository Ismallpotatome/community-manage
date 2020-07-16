package com.community.manage.mapper;

import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbMangeMail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMangeMailMapper {
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
    List<TbMangeMail> selectByCondition(@Param("keyword") String keyword, @Param("begin") String begin, @Param("end") String end, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 这里是添加
     *
     * @param tbMangeMail 需要插入的对象
     * @return
     */
    int insertMangeActivity(@Param("tbMangeMail") TbMangeMail tbMangeMail);

    /**
     * 这里对应修改尾部修改按钮
     *
     * @param tbMangeMail
     * @return
     */
    int updateAll(@Param("tbMangeMail") TbMangeMail tbMangeMail);

    /**
     * 这里对应尾部的删除按钮
     *
     * @param MailId
     * @return
     */
    int delById(@Param("MailId") int MailId);
}