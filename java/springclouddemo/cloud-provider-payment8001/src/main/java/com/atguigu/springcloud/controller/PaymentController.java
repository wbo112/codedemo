package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info(" insert result : {}", result);
        if (result > 0) {
            return new CommonResult(200, "insert success,server.port :"+serverPort,  result);
        } else {
            return new CommonResult(400, "insert fail", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info(" insert result : {}", result);
        if (Objects.nonNull(result)) {
            return new CommonResult(200, "query success,server.port :"+serverPort,  result);
        } else {
            return new CommonResult(400, "query fail", null);
        }
    }

}
