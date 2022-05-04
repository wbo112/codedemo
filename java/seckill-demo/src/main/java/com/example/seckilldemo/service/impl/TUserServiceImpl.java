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
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public RespBean doLogin(LoginVo loginVo) throws GlobalException {
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

        return RespBean.success(RespBeanEnum.SUCCESS);
    }
}
