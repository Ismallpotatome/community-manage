package com.community.manage.controller;
import com.community.manage.domain.dto.BuildDto;
import com.community.manage.service.BuildService;
import com.community.manage.util.Result;
import com.community.manage.util.TwoResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/build")
public class BuildController {
    @Resource
    BuildService buildService;
    /**
     *  查询栋数,小区创建时间按照在两个日期之间,再按照栋数名模糊查询出小区集合分页显示
     *
     * @param buildDto 封装了开始时间startDate, 结束时间endDate, 页数page和每页有多少条数据size,还有栋数名称
     * @return
     */
    @PostMapping("/selectByDate")
    public Result<TwoResult<List<BuildDto>>> selectByFilter(@RequestBody BuildDto buildDto) {
        TwoResult<List<BuildDto>> result = buildService.selectByKeyword(buildDto);
        return Result.success(result);
    }

    /**
     * 删除一条数据,保证删除一条数据后该页面的数据条数不变
     *
     * @param buildDto 封装了开始时间startDate, 结束时间endDate, 页数page和每页有多少条数据size,
     *                     要删除的communityId
     * @return
     */
    @PostMapping("/deleteOne")
    public Result<List<BuildDto>> deleteOne(@RequestBody BuildDto buildDto) {
        List<BuildDto> buildDtos = buildService.deleteOne(buildDto);
        return Result.success(buildDtos);
    }

    /**
     * 批量删除当前页面中的记录,保证当前页面记录条数不变
     *
     * @param buildDtos 把所有数据的id封装进集合还在第一个元素封装了startDate,endDate,page,size
     * @return
     */
    @PostMapping("/deleteBatch")
    public Result<List<BuildDto>> deleteBatch(@RequestBody List<BuildDto> buildDtos) {
        List<BuildDto> dtos = buildService.deleteBatch(buildDtos);
        return Result.success(dtos);
    }

    /**
     * 更改小区信息
     * @param buildDto 封装了一条栋数的信息,还有startDate,endDate,page,size
     * @return 返回修改后当前页面数据条数
     */
    @PostMapping("/updateOne")
    public Result<List<BuildDto>> updateOne(@RequestBody BuildDto buildDto) {
        List<BuildDto> dtos = buildService.updateOne(buildDto);
        return Result.success(dtos);
    }

    /**
     * 插入一条数据
     * @param buildDto 封装了一条栋数的信息
     * @return 成功返回:插入成功,失败返回:插入失败
     */
    @PostMapping("/insertOne")
    public Result<String> insertOne(@RequestBody BuildDto buildDto) {
        String s = buildService.insertOne(buildDto);
        return Result.success(s);
    }
}
