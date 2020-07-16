package com.community.manage.controller;
import com.community.manage.domain.dto.HomeDto;
import com.community.manage.service.HomeService;
import com.community.manage.util.Result;
import com.community.manage.util.TwoResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/home")
public class HomeController {
    @Resource
    HomeService homeService;
    /**
     *  查询栋数,房产创建时间按照在两个日期之间,再按照栋数名模糊查询出小区集合分页显示
     *
     * @param homeDto 封装了开始时间startDate, 结束时间endDate, 页数page和每页有多少条数据size,还有栋数名称
     * @return
     */
    @PostMapping("/selectByDate")
    public Result<TwoResult<List<HomeDto>>> selectByFilter(@RequestBody HomeDto homeDto) {
        TwoResult<List<HomeDto>> twoResult = homeService.selectByKeyword(homeDto);
        return Result.success(twoResult);
    }

    /**
     * 删除一条数据,保证删除一条数据后该页面的数据条数不变
     *
     * @param homeDto 封装了开始时间startDate, 结束时间endDate, 页数page和每页有多少条数据size,
     *                     要删除的communityId
     * @return
     */
    @PostMapping("/deleteOne")
    public Result<List<HomeDto>> deleteOne(@RequestBody HomeDto homeDto) {
        List<HomeDto> homeDtos = homeService.deleteOne(homeDto);
        return Result.success(homeDtos);
    }

    /**
     * 批量删除当前页面中的记录,保证当前页面记录条数不变
     *
     * @param homeDtos 把所有数据的id封装进集合还在第一个元素封装了startDate,endDate,page,size
     * @return
     */
    @PostMapping("/deleteBatch")
    public Result<List<HomeDto>> deleteBatch(@RequestBody List<HomeDto> homeDtos) {
        List<HomeDto> dtos = homeService.deleteBatch(homeDtos);
        return Result.success(dtos);
    }

    /**
     * 更改小区信息
     * @param homeDto 封装了一条房产的信息,还有startDate,endDate,page,size
     * @return 返回修改后当前页面数据条数
     */
    @PostMapping("/updateOne")
    public Result<String> updateOne(@RequestBody HomeDto homeDto) {
        String s = homeService.updateOne(homeDto);
        return Result.success(s);
    }

    /**
     * 插入一条数据
     * @param homeDto 封装了一条房产的信息
     * @return 成功返回:插入成功,失败返回:插入失败
     */
    @PostMapping("/insertOne")
    public Result<String> insertOne(@RequestBody HomeDto homeDto) {
        String s = homeService.addOne(homeDto);
        return Result.success(s);
    }
}
