package com.community.manage.controller;

import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.service.AssetsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Resource(name = "assetsServiceImpl")
    AssetsService assetsService;
    @RequestMapping("/shows")
    public AssetsBean showAllInfo(){
        AssetsBean assetsBean = assetsService.showAllInfo();
        return assetsBean;
    }
}
