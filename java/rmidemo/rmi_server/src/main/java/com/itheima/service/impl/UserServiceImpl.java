package com.itheima.service.impl;

import com.itheima.interf.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) {

        return "成功调用了 sayHello(name) :"+name;
    }
}
