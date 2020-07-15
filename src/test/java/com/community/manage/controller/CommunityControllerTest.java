package com.community.manage.controller;

import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml"})
public class CommunityControllerTest {
    @Resource
    CommunityController communityController;
    @Test
    public void selectByFilter() {
        CommunityDto filterDto = new CommunityDto();
        filterDto.setSize(3);
        filterDto.setPage(1);
        filterDto.setEndDate("2020-07-13 10:44:16");
        filterDto.setEndDate("2020-07-13 11:22:41");
        Result<List<CommunityDto>> listResult = communityController.selectByFilter(filterDto);
        System.out.println(listResult);
    }
}