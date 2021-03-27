package com.itheima.service;

import com.itheima.interf.UserService;
import com.itheima.service.impl.UserServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServiceMain {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        //1、启动RMI注册服务,指定端口号
        LocateRegistry.createRegistry(8888);
        //2、创建要被访问的远程对象的实例
        UserService userService=new UserServiceImpl();

        //3、把远程对象实例注册到RMI注册服务器上
        Naming.bind("rmi://localhost:8888/UserService",userService);

        System.out.println("服务器启动成功");


    }
}
