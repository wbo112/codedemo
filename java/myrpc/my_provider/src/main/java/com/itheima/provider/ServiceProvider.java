package com.itheima.provider;

import com.itheima.interf.service.HelloService;
import com.itheima.pojo.URL;
import com.itheima.registry.NativeRegistry;
import com.itheima.server.HttpServer;
import com.itheima.service.impl.HelloServiceImpl;

public class ServiceProvider {
    public static void main(String[] args) {
        URL url = new URL("localhost", 8080);
        NativeRegistry.regist(HelloService.class.getName(), url, HelloServiceImpl.class);
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getName(),url.getPort());
    }
}
