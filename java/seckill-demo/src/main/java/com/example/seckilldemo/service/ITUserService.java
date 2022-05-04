package com.example.seckilldemo.service;

import com.example.seckilldemo.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckilldemo.exception.GlobalException;
import com.example.seckilldemo.vo.LoginVo;
import com.example.seckilldemo.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-09-04
 */
public interface ITUserService extends IService<TUser> {

    RespBean doLogin(LoginVo loginVo) throws GlobalException;
}
