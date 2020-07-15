package com.community.manage.controller;

import com.community.manage.domain.dto.AssetsSearchDto;
import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.service.AssetsService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Resource(name = "assetsServiceImpl")
    AssetsService assetsService;

    /**
     * 展示所有的信息
     * @return
     */
    @RequestMapping("/shows")
    public ResponseEntity<AssetsBean> showAllInfo(){
        AssetsBean assetsBean = assetsService.showAllInfo();
        return ResponseEntity.success(assetsBean);
    }

    /**
     * 通过条件进行查询
     * @param assetsSearchDto
     * @return
     */
    @RequestMapping("/search")
    public ResponseEntity<AssetsBean> searchByKey(@RequestBody() AssetsSearchDto assetsSearchDto){
        AssetsBean assetsBean = assetsService.searchByKey(assetsSearchDto);
        return ResponseEntity.success(assetsBean);
    }

    /**
     * 通过ID删除信息
     * @param assetsId
     * @return
     */
    @RequestMapping("/delete")
    public ResponseEntity deletAssets(int assetsId){
        ResponseEntity responseEntity = assetsService.deleteById(assetsId);
        return responseEntity;
    }

    public ResponseEntity deleteAssets(int[] assetsIds){
        return null;
    }
}
