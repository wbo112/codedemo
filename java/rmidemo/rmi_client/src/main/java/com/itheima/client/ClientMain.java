package com.itheima.client;

import com.itheima.interf.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ClientMain {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //3、把远程对象实例注册到RMI注册服务器上
        UserService userService = (UserService)Naming.lookup("rmi://localhost:8888/UserService");

        String str = userService.sayHello("client");
        System.out.println(str);

    }
}
