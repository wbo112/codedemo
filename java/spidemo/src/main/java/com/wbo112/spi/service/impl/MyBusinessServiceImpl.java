package com.wbo112.spi.service.impl;

import com.wbo112.spi.service.BusinessService;

public class MyBusinessServiceImpl implements BusinessService {
    @Override
    public void queryData() {
        System.out.println("this is MyBusinessServiceImpl");
    }
}
