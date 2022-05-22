package com.example.seckilldemo.a.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TSeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 订单价格
     */
    private BigDecimal seckillPrice;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 秒杀库存数量
     */
    private LocalDateTime startDate;

    /**
     * 秒杀结束时间
     */
    private LocalDateTime endDate;


}
