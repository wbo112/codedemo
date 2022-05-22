package com.wbo112.demo1.impl;

import com.wbo112.demo1.IHelloWorld;

public class MyHelloWorld  implements IHelloWorld {
    @Override
    public String hi() {
        return "My Hello World";
    }
}
