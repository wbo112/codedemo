package com.itheima.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.itheima.interf.UserService;

import java.net.MalformedURLException;


public class ClientMain {
    public static void main(String[] args) throws MalformedURLException {
        String url="http://localhost:8888/api/service";
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        UserService userService =(UserService) hessianProxyFactory.create(UserService.class, url);
        String str = userService.sayHello("hessian客户端");
        System.out.println(str);
    }
}
