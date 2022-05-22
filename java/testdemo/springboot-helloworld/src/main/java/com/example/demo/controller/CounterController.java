package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String count() {
        Long count = redisTemplate.opsForValue().increment("count-people");
        return "有 " + count + "人访问这个页面";
    }
}
