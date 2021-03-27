
package com.itheima.interf;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    //接口必须抛出RemoteException异常
    String sayHello(String name) throws RemoteException;
}
