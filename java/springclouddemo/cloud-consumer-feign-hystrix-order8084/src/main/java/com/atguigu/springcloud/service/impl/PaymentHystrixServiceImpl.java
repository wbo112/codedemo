package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return  "PaymentHystrixServiceImpl"+" "+"paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return  "PaymentHystrixServiceImpl"+" "+"paymentInfo_Timeout";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "a";
    }
}
