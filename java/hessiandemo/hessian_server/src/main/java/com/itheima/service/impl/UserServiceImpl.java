package com.itheima.service.impl;

import com.itheima.interf.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name)  {
        return name+" hessian 服务端返回";
    }
}
