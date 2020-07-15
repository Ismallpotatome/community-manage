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
        List<CommunityDto> dtos = communityService.selectByFilter(filter);
        return Result.success(dtos);
    }

    /**
     * 删除一条数据,保证删除一条数据后该页面的数据条数不变
     *
     * @param communityDto 封装了开始时间startDate, 结束时间endDate, 页数page和每页有多少条数据size,
     *                     要删除的communityId
     * @return
     */
    @PostMapping("/deleteOne")
    public Result<List<CommunityDto>> deleteOne(@RequestBody CommunityDto communityDto) {
        List<CommunityDto> communityDtos = communityService.deleteOne(communityDto);
        if (communityDtos == null) {
            return Result.success(null);
        }
        return Result.success(communityDtos);
    }

    /**
     * 批量删除当前页面中的记录,保证当前页面记录条数不变
     *
     * @param communityDtos 把所有数据的id封装进集合还在第一个元素封装了startDate,endDate,page,size
     * @return
     */
    @PostMapping("/deleteBatch")
    public Result<List<CommunityDto>> deleteOne(@RequestBody List<CommunityDto> communityDtos) {
        List<CommunityDto> dtos = communityService.deleteBatch(communityDtos);
        if (communityDtos == null) {
            return Result.success(null);
        }
        return Result.success(dtos);
    }

    /**
     * 更改小区信息
     * @param communityDto 封装了一条小区的信息,还有startDate,endDate,page,size
     * @return 返回修改后当前页面数据条数
     */
    @GetMapping("/updateOne")
    public Result<List<CommunityDto>> updateOne(@RequestBody CommunityDto communityDto) {
        List<CommunityDto> communityDtos = communityService.updateOne(communityDto);
        if (communityDtos == null) {
            return Result.success(null);
        }
        return Result.success(communityDtos);
    }

    /**
     * 插入一条数据
     * @param communityDto 封装了一条小区的信息
     * @return 成功返回:插入成功,失败返回:插入失败
     */
    @PostMapping("/insertOne")
    public Result<String> insertOne(@RequestBody CommunityDto communityDto) {
        String s = communityService.insertOne(communityDto);
        return Result.success(s);
    }

    /**
     * 修改记录为停用或为显示
     * @param status 要修改的状态
     * @return 返回回修改后的状态
     */
    @GetMapping("/status")
    public Result<String> updateStatus(int communityId, String status) {
        String s = communityService.updateStatus(communityId, status);
        return Result.success(s);
    }
}
