package com.example.seckilldemo.service.impl;

import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.exception.GlobalException;
import com.example.seckilldemo.mapper.TUserMapper;
import com.example.seckilldemo.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckilldemo.util.MD5Util;
import com.example.seckilldemo.util.ValidatorUtil;
import com.example.seckilldemo.vo.LoginVo;
import com.example.seckilldemo.vo.RespBean;
import com.example.seckilldemo.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-04
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private RedisTemplate<String,Object>  redisTemplate;

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) throws GlobalException {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(password)) {
            return RespBean.error(RespBeanEnum.LOGINERR);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return RespBean.error(RespBeanEnum.MOBILEERR);
        }

        TUser tUser = tUserMapper.selectById(mobile);

        if (Objects.isNull(tUser)) {
            throw new GlobalException(RespBeanEnum.LOGINERR);
            //  return RespBean.error(RespBeanEnum.LOGINERR);
        }
        if (!MD5Util.formPassToDBPass(password, tUser.getSlat()).equals(tUser.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGINERR);
        }
        String ticket = UUID.randomUUID().toString();
        request.getSession().setAttribute(ticket, tUser);
        redisTemplate.opsForValue().set("user:"+ticket,tUser);
        Cookie userTicket = new Cookie("userTicket", ticket);
        userTicket.setPath("/");
        response.addCookie(userTicket);
        return RespBean.success(RespBeanEnum.SUCCESS);
    }

    @Override
    public TUser getUserByCookie(String userTicker) {
        if(StringUtils.isBlank(userTicker)){
            return null;
        }
        return (TUser) redisTemplate.opsForValue().get("user:"+userTicker);
    }
}
