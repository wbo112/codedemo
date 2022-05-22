package com.example.seckilldemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckilldemo.entity.TGoods;
import com.example.seckilldemo.mapper.TGoodsMapper;
import com.example.seckilldemo.service.ITGoodsService;
import com.example.seckilldemo.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements ITGoodsService {

	@Autowired
	private TGoodsMapper goodsMapper;


	@Override
	public List<GoodsVo> findGoodsVo() {
		return goodsMapper.findGoodsVo();
	}




	@Override
	public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
		return goodsMapper.findGoodsVoByGoodsId(goodsId);
	}
}
