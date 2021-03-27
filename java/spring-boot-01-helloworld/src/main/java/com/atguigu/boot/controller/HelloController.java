package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @Autowired
    Car car;


    @RequestMapping("/car")
    public  Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello,Spring Boot2! 你好";
    }


}
