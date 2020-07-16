package com.community.manage.controller;

import com.community.manage.domain.dto.ChargeItemInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.vo.ChargeItemBean;
import com.community.manage.service.ChargeItemService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("charge/item")
public class ChargeItemController {

    @Resource
    ChargeItemService chargeItemService;

    /**
     * 展示所有的信息
     * @return
     */
    @RequestMapping("shows")
    public ResponseEntity showAllCharge(){
        List<ChargeItemBean> chargeBeans = chargeItemService.showAllInfo();
        return ResponseEntity.success(chargeBeans);
    }

    /**
     * 通过条件进行查询
     * @param chargeSearchDto
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<List<ChargeItemBean>> searchByKey(@RequestBody() SearchDto chargeSearchDto){
        List<ChargeItemBean> chargeItemBeans = chargeItemService.searchByKey(chargeSearchDto);
        return ResponseEntity.success(chargeItemBeans);
    }

    /**
     * 通过ID删除信息
     * @param chargeIds
     * @return
     */
    @RequestMapping("/delete")
    public ResponseEntity deletAssets(int chargeIds){
        ResponseEntity responseEntity = chargeItemService.deleteById(chargeIds);
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
        ResponseEntity responseEntity = chargeItemService.deleteById(chargeIds);
        return responseEntity;
    }

    /**
     * 插入新数据
     * @param chargeItemInfoDto 前端传输过来的数据
     * @return
     */
    @PostMapping("insert")
    public ResponseEntity insertNewAssets(@RequestBody ChargeItemInfoDto chargeItemInfoDto){
        ResponseEntity responseEntity = chargeItemService.insertChargeItem(chargeItemInfoDto);
        return responseEntity;
    }

    /**
     * 更新数据
     * @param chargeItemInfoDto
     * @return
     */
    @PostMapping("update")
    public ResponseEntity updateAssetsInfo(@RequestBody ChargeItemInfoDto chargeItemInfoDto){
        ResponseEntity responseEntity = chargeItemService.updateChargeItem(chargeItemInfoDto);
        return responseEntity;
    }
}
