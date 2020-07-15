package com.community.manage.controller;

import com.community.manage.domain.dto.ChargeInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.vo.ChargeBean;
import com.community.manage.service.ChargeService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/charge")
public class ChargeController {
    @Resource
    ChargeService chargeService;

    /**
     * 展示所有的信息
     * @return
     */
    @RequestMapping("shows")
    public ResponseEntity showAllCharge(){
        List<ChargeBean> chargeBeans = chargeService.showAllInfo();
        return ResponseEntity.success(chargeBeans);
    }

    /**
     * 通过条件进行查询
     * @param chargeSearchDto
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<List<ChargeBean>> searchByKey(@RequestBody() SearchDto chargeSearchDto){
        List<ChargeBean> chargeBeans = chargeService.searchByKey(chargeSearchDto);
        return ResponseEntity.success(chargeBeans);
    }

    /**
     * 通过ID删除信息
     * @param chargeIds
     * @return
     */
    @RequestMapping("/delete")
    public ResponseEntity deletAssets(int chargeIds){
        ResponseEntity responseEntity = chargeService.deleteById(chargeIds);
        return responseEntity;
    }

    /**
     * 通过ID批量删除
     * @param chargeIds
     * @return
     * @throws Exception
     */
    @PostMapping("/deletes")
    public ResponseEntity deleteAssets(@RequestBody int[] chargeIds) throws Exception {
        ResponseEntity responseEntity = chargeService.deleteById(chargeIds);
        return responseEntity;
    }

    /**
     * 插入新数据
     * @param chargeInfoDto 前端传输过来的数据
     * @return
     */
    @PostMapping("insert")
    public ResponseEntity insertNewAssets(@RequestBody ChargeInfoDto chargeInfoDto){
        ResponseEntity responseEntity = chargeService.insertAssets(chargeInfoDto);
        return responseEntity;
    }

    /**
     * 更新数据
     * @param chargeInfoDto
     * @return
     */
    @PostMapping("update")
    public ResponseEntity updateAssetsInfo(@RequestBody ChargeInfoDto chargeInfoDto){
        ResponseEntity responseEntity = chargeService.updateAssets(chargeInfoDto);
        return responseEntity;
    }
}
