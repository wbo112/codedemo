package com.example.seckilldemo.a.service.impl;

import com.example.seckilldemo.a.entity.TOrder;
import com.example.seckilldemo.a.mapper.TOrderMapper;
import com.example.seckilldemo.a.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-20
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
