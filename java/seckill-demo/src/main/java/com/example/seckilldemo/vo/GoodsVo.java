package com.example.seckilldemo.vo;

import com.example.seckilldemo.entity.TGoods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends TGoods {

	private BigDecimal seckillPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
}