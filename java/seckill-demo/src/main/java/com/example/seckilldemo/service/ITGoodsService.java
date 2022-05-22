package com.example.seckilldemo.service;

import com.example.seckilldemo.entity.TGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckilldemo.vo.GoodsVo;

import java.util.List;


public interface ITGoodsService extends IService<TGoods> {


    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
