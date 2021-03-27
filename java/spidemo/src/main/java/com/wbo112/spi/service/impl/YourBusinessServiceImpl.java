package com.wbo112.spi.service.impl;

import com.wbo112.spi.service.BusinessService;

public class YourBusinessServiceImpl  implements BusinessService {
    @Override
    public void queryData() {
        System.out.println("this is YourBusinessServiceImpl");
    }
}
