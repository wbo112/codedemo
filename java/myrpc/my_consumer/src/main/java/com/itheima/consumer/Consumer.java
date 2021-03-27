package com.itheima.consumer;

import com.itheima.interf.service.HelloService;
import com.itheima.interf.service.Invocation;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Object[]{"myRPC"}, new Class[]{String.class});
        HttpClient httpClient = new HttpClient();
        String result = httpClient.post("localhost", 8080, invocation);
        System.out.println(result);

    }
}
