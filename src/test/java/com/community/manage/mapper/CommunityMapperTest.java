package com.community.manage.mapper;

import com.community.manage.domain.entity.Community;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml"})
public class CommunityMapperTest {
    @Resource
    CommunityMapper communityMapper;
    @Test
    public void deleteOne() {
        int i = communityMapper.deleteOne(2);
        System.out.println(i);
    }

    @Test
    public void deleteBatch() {
        ArrayList<Community> list = new ArrayList<>();
        for (int i = 41; i < 46; i++) {
            Community community = new Community();
            community.setCommunityId(i);
            list.add(community);
        }
        int i = communityMapper.deleteBatch(list);
        System.out.println(i);
    }

    @Test
    public void updateOne() {
        Community community = new Community();
        community.setCommunityId(48);
        community.setCommunityCompany("gtyuhj");
        communityMapper.updateOne(community);
    }

    @Test
    public void insertOne() {
    }
}