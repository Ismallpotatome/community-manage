package com.community.manage.controller;

import com.community.manage.domain.dto.CommunityDto;
import com.community.manage.service.CommunityService;
import com.community.manage.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {
    @Resource
    CommunityService communityService;
    /**
     *  查询小区,小区创建时间按照在两个日期之间,再按照小区名模糊查询出小区集合分页显示
     *
     * @param filter 封装了开始时间startDate, 结束时间endDate, 页数page和每页有多少条数据size
     * @return
     */
    @PostMapping("/selectByDate")
    public Result<List<CommunityDto>> selectByFilter(@RequestBody CommunityDto filter) {
        List<CommunityDto> communityDtos = communityService.selectByFilter(filter);
        return Result.success(communityDtos);
    }

    /**
     * 删除一条数据,保证删除一条数据后该页面的数据条数不变
     *
     * @param communityId 通过小区的id删除数据
     * @param page 当前页数
     * @param size 一页中的条数
     * @return
     */
    @PostMapping("/deleteOne")
    public Result<CommunityDto> deleteOne(int communityId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return null;
    }

    /**
     * 批量删除当前页面中的记录,保证当前页面记录条数不变
     *
     * @param communityDto 把所有数据的id封装进集合
     * @param page 当前页数
     * @param size 一页中的条数
     * @return
     */
    @PostMapping("/deleteBatch")
    public Result<CommunityDto> deleteOne(@RequestBody List<CommunityDto> communityDto, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return null;
    }

    @GetMapping("/updateOne")
    public Result<String> updateOne(int communityId) {
        return null;
    }
    @PostMapping("/insertOne")
    public Result<String> insertOne(CommunityDto communityDto) {
        return null;
    }

}
