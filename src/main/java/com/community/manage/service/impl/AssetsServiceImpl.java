package com.community.manage.service.impl;

import com.community.manage.domain.dto.AssetsInfoDto;
import com.community.manage.domain.dto.SearchDto;
import com.community.manage.domain.entity.Assets;
import com.community.manage.domain.vo.AssetsBean;
import com.community.manage.mapper.AssetsMapper;
import com.community.manage.service.AssetsService;
import com.community.manage.util.GenerateCodeUtil;
import com.community.manage.util.ResponseEntity;
import com.community.manage.util.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {
    @Resource
    AssetsMapper assetsMapper;

    /**
     * 查询所有的信息，逻辑处理
     * @return
     */
    @Override
    public List<AssetsBean> showAllInfo() {
        List<AssetsBean> assetsBeans = assetsMapper.selectAll();
        return assetsBeans;
    }

    /**
     * 通过关键字和时间区间查询对应的信息
     * @param assetsSearchDto
     * @return
     */
    @Override
    public List<AssetsBean> searchByKey(SearchDto assetsSearchDto) {
        List<AssetsBean> assetsBeans = assetsMapper.selectByKey(assetsSearchDto);
        return assetsBeans;
    }

    /**
     * 通过ID删除单个信息
     * @param assetsId
     * @return
     */
    @Override
    public ResponseEntity deleteById(int assetsId) {
        int i = assetsMapper.updateStatusById(assetsId);
        if(i>0) {
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error();
        }
    }

    /**
     * 通过ID删除多个信息
     * @param assetsIds
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public ResponseEntity deleteById(int[] assetsIds) throws Exception{
        int i = assetsMapper.updateStatusByIds(assetsIds);
        System.out.println(i);
        if(i == assetsIds.length){
            return ResponseEntity.success();
        }
        throw new ServiceException();
    }

    /**
     * 插入新的信息
     * @param assetsNewInfo
     * @return
     */
    @Override
    public ResponseEntity insertAssets(AssetsInfoDto assetsNewInfo) {
        Assets assets = new Assets();
        //生成随机编号
        String num = GenerateCodeUtil.createCodeNum("CJ");
        /**
         * 设置所有的需要插入数据
         */
        assets.setAssetsNum(num);
        assets.setAssetsName(assetsNewInfo.getAssetsName());
        assets.setAssetsBrand(assetsNewInfo.getAssetsBrand());
        assets.setAssetsPurchasePrice(assetsNewInfo.getAssetsPurchasePrice());
        assets.setAssetsPurchaseQuantity(assetsNewInfo.getAssetsPurchaseQuantity());
        assets.setAssetsLife(assetsNewInfo.getAssetsLife());
        assets.setAssetsEstablishDate(assetsNewInfo.getAssetsEstablishDate());
        //通过小区名字获取小区的ID
        assets.setCommunityId(selectIdByName(assetsNewInfo.getCommunityName()));

        int insert = assetsMapper.insert(assets);
        if(insert>0){
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    /**
     * 根据ID更新数据
     * @param assetsNewInfo
     * @return
     */
    @Override
    public ResponseEntity updateAssets(AssetsInfoDto assetsNewInfo) {
        Assets assets = new Assets();
        /**
         * 设置所有的需要插入数据
         */
        assets.setAssetsNum(assetsNewInfo.getAssetsNum());
        assets.setAssetsId(assetsNewInfo.getAssetsId());
        assets.setAssetsName(assetsNewInfo.getAssetsName());
        assets.setAssetsBrand(assetsNewInfo.getAssetsBrand());
        assets.setAssetsPurchasePrice(assetsNewInfo.getAssetsPurchasePrice());
        assets.setAssetsPurchaseQuantity(assetsNewInfo.getAssetsPurchaseQuantity());
        assets.setAssetsLife(assetsNewInfo.getAssetsLife());
        assets.setAssetsEstablishDate(assetsNewInfo.getAssetsEstablishDate());
        //通过小区名字获取小区的ID
        assets.setCommunityId(selectIdByName(assetsNewInfo.getCommunityName()));

        int insert = assetsMapper.updateByPrimaryKeySelective(assets);
        if(insert>0){
            return ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

    /**
     * 通过Name获取ID
     * @param commounityName
     * @return
     */
    private int selectIdByName(String commounityName){
        return 1;
    }
}
