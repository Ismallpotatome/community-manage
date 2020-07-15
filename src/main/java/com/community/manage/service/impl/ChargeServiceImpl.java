package com.community.manage.service.impl;

import com.community.manage.domain.dto.ChargeInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.entity.Charge;
import com.community.manage.domain.vo.ChargeBean;
import com.community.manage.mapper.ChargeMapper;
import com.community.manage.service.ChargeService;
import com.community.manage.util.GenerateCodeUtil;
import com.community.manage.util.ResponseEntity;
import com.community.manage.util.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {
    @Resource
    ChargeMapper chargeMapper;

    /**
     * 查询所有的信息
     * @return
     */
    @Override
    public List<ChargeBean> showAllInfo() {
        List<ChargeBean> chargeBeans = chargeMapper.selectAll();
        return chargeBeans;
    }

    /**
     * 通过关键字和时间区间查询对应的信息
     * @param chargeSearchDto
     * @return
     */
    @Override
    public List<ChargeBean> searchByKey(SearchDto chargeSearchDto) {
        List<ChargeBean> chargeBeans = chargeMapper.selectByKey(chargeSearchDto);
        return chargeBeans;
    }

    /**
     * 单个删除
     * @param chargeId
     * @return
     */
    @Override
    public ResponseEntity deleteById(int chargeId) {
        int i = chargeMapper.updateStatusById(chargeId);
        if(i>0) {
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error();
        }
    }

    /**
     * 批量删除
     * @param chargeIds
     * @return
     * @throws Exception
     */
    @Override
    public ResponseEntity deleteById(int[] chargeIds) throws Exception {
        int i = chargeMapper.updateStatusByIds(chargeIds);
        if(i == chargeIds.length){
            return ResponseEntity.success();
        }
        throw new ServiceException();
    }

    /**
     * 插入数据
     * @param chargeInfoDto
     * @return
     */
    @Override
    public ResponseEntity insertAssets(ChargeInfoDto chargeInfoDto) {
        Charge charge = new Charge();
        //获取随机ID
        String num = GenerateCodeUtil.createCodeNum("EP");

        charge.setChargeNum(num);
        charge.setChargeName(chargeInfoDto.getChargeName());
        charge.setCommunityId(selectIdByName(chargeInfoDto.getCommunityName()));

        int i = chargeMapper.insertSelective(charge);
        if(i>0){
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    /**
     * 更新数据
     * @param chargeInfoDto
     * @return
     */
    @Override
    public ResponseEntity updateAssets(ChargeInfoDto chargeInfoDto) {
        Charge charge = new Charge();

        charge.setChargeName(chargeInfoDto.getChargeName());
        charge.setCommunityId(selectIdByName(chargeInfoDto.getCommunityName()));

        int i = chargeMapper.updateByPrimaryKeySelective(charge);
        if(i>0){
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    /**
     * 名称反向获取ID
     * @param commounityName
     * @return
     */
    private int selectIdByName(String commounityName){
        return 1;
    }
}
