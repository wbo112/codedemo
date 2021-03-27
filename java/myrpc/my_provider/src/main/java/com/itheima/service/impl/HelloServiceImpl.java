package com.itheima.service.impl;

import com.itheima.interf.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name+" 服务端调用";
    }
}
