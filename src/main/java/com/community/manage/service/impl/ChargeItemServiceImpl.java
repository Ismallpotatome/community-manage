package com.community.manage.service.impl;

import com.community.manage.domain.dto.ChargeItemInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.entity.Charge;
import com.community.manage.domain.entity.ChargeItem;
import com.community.manage.domain.vo.ChargeItemBean;
import com.community.manage.mapper.ChargeItemMapper;
import com.community.manage.mapper.ChargeMapper;
import com.community.manage.service.ChargeItemService;
import com.community.manage.util.ResponseEntity;
import com.community.manage.util.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChargeItemServiceImpl implements ChargeItemService {
    @Resource
    ChargeItemMapper chargeItemMapper;
    @Resource
    ChargeMapper chargeMapper;
    @Override
    public List<ChargeItemBean> showAllInfo() {
        List<ChargeItemBean> chargeItemBeans = chargeItemMapper.selectAll();
        return chargeItemBeans;
    }

    @Override
    public List<ChargeItemBean> searchByKey(SearchDto chargeItemSearchDto) {
        List<ChargeItemBean> chargeItemBeans = chargeItemMapper.selectByKey(chargeItemSearchDto);
        return chargeItemBeans;
    }

    @Override
    public ResponseEntity deleteById(int chargeId) {
        int i = chargeItemMapper.updateStatusById(chargeId);
        if(i>0){
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity deleteById(int[] chargeIds) throws Exception {
        int i = chargeItemMapper.updateStatusByIds(chargeIds);
        if(i == chargeIds.length){
            return ResponseEntity.success();
        }
        throw new ServiceException();
    }

    @Override
    public ResponseEntity insertChargeItem(ChargeItemInfoDto chargeItemNewInfo) {

        ChargeItem chargeItem = new ChargeItem();
        /**
         * 将前端参数封装到数据库对应的实体类中
         * 进行插入操作
         */
        chargeItem.setChargeId(selectChargeNameById(chargeItemNewInfo.getChargeName(),chargeItemNewInfo.getCommunityName()));
        chargeItem.setChargeOwner(chargeItemNewInfo.getChargeOwner());
        chargeItem.setReceivableAmount(chargeItemNewInfo.getReceivableAmount());
        chargeItem.setActualAmount(chargeItemNewInfo.getActualAmount());
        chargeItem.setChargeRemark(chargeItemNewInfo.getChargeRemark());
        chargeItem.setChargePaymentDate(chargeItemNewInfo.getChargePaymentDate());

        int i = chargeItemMapper.insertSelective(chargeItem);

        if(i>0){
            return ResponseEntity.success();
        }

        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity updateChargeItem(ChargeItemInfoDto chargeItemInfo) {

        ChargeItem chargeItem = new ChargeItem();

        chargeItem.setChargeOwner(chargeItemInfo.getChargeOwner());
        chargeItem.setReceivableAmount(chargeItemInfo.getReceivableAmount());
        chargeItem.setActualAmount(chargeItemInfo.getActualAmount());
        chargeItem.setChargeRemark(chargeItemInfo.getChargeRemark());
        chargeItem.setChargePaymentDate(chargeItemInfo.getChargePaymentDate());

        int i = chargeItemMapper.updateByPrimaryKeySelective(chargeItem);

        if(i>0){
            return ResponseEntity.success();
        }

        return ResponseEntity.error();
    }

    /**
     * 通过小区名字好缴费项目反向获取id
     */
    private int selectChargeNameById(String chargeName,String communityName){

        Charge charge = chargeMapper.selectByName(chargeName, communityName);

        return  charge.getChargeId();
    }
}
