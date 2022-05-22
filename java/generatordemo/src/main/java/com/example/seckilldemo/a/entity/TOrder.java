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
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 收货地址ID
     */
    private Long deliveryAddId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 订单详情
     */
    private String goodsDetail;

    /**
     * 订单价格
     */
    private BigDecimal goodsPrice;

    /**
     * 1pc,2android,3ios
     */
    private Integer orderChannel;

    /**
     * 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成
     */
    private Integer status;

    /**
     * 订单的创建时间
     */
    private LocalDateTime createDate;

    /**
     * 支付时间
     */
    private LocalDateTime payDate;


}
