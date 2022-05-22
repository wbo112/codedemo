package com.example.seckilldemo.config;

import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private ITUserService itUserService;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz=parameter.getParameterType();

        return TUser.class==clazz;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Optional<Cookie> optionalCookie = Arrays.stream(webRequest.getNativeRequest(HttpServletRequest.class).getCookies()).filter(cookie1 -> "userTicket".equals(cookie1.getName())).findFirst();
        if(optionalCookie.isEmpty()){
            return null;
        }


        return itUserService.getUserByCookie(optionalCookie.get().getValue());
    }
}
