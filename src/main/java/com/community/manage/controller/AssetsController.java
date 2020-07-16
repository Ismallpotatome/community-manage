package com.community.manage.controller;

import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.dto.AssetsInfoDto;
import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.service.AssetsService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public ResponseEntity<List<AssetsBean>> showAllInfo(){
        List<AssetsBean> assetsBeans = assetsService.showAllInfo();
        return ResponseEntity.success(assetsBeans);
    }

    /**
     * 通过条件进行查询
     * @param assetsSearchDto
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<List<AssetsBean>> searchByKey(@RequestBody() SearchDto assetsSearchDto){
        List<AssetsBean> assetsBeans = assetsService.searchByKey(assetsSearchDto);
        return ResponseEntity.success(assetsBeans);
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

    /**
     * 通过ID批量删除
     * @param assetsIds
     * @return
     * @throws Exception
     */
    @PostMapping("/deletes")
    public ResponseEntity deleteAssets(@RequestBody int[] assetsIds) throws Exception {

        ResponseEntity responseEntity = assetsService.deleteById(assetsIds);

        return responseEntity;
    }

    /**
     * 插入新数据
     * @param assetsUpdateInfo 前端传输过来的数据
     * @return
     */
    @PostMapping("/insert")
    public ResponseEntity insertNewAssets(@RequestBody AssetsInfoDto assetsUpdateInfo){

        ResponseEntity responseEntity = assetsService.insertAssets(assetsUpdateInfo);

        return responseEntity;
    }
    @PostMapping("/update")
    public ResponseEntity updateAssetsInfo(@RequestBody AssetsInfoDto assetsUpdateInfo){

        ResponseEntity responseEntity = assetsService.updateAssets(assetsUpdateInfo);

        return responseEntity;
    }
}
