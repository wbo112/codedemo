package com.example.seckilldemo.controller;

import com.example.seckilldemo.exception.GlobalException;
import com.example.seckilldemo.service.ITUserService;
import com.example.seckilldemo.service.impl.TUserServiceImpl;
import com.example.seckilldemo.vo.LoginVo;
import com.example.seckilldemo.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private ITUserService itUserService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) throws GlobalException {
        log.info("{}",loginVo);

        return itUserService.doLogin(loginVo,request,response);

    }
}
