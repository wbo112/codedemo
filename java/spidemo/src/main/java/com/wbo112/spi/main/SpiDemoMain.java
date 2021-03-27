package com.wbo112.spi.main;

import com.wbo112.spi.service.BusinessService;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemoMain {
    public static void main(String[] args) {
        ServiceLoader<BusinessService> services = ServiceLoader.load(BusinessService.class);
        Iterator<BusinessService> iterator = services.iterator();
        BusinessService businessService;
        while(iterator.hasNext()){
            businessService=iterator.next();
            System.out.println("========================");
            System.out.println(businessService.getClass().getName());
            businessService.queryData();
        }

    }
}
