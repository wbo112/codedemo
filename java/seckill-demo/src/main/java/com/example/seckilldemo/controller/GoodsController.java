package com.example.seckilldemo.controller;

import com.example.seckilldemo.entity.TUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 商品
 * 乐字节：专注线上IT培训
 * 答疑老师微信：lezijie
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ThymeleafViewResolver thymeleafViewResolver;

	/**
	 * 功能描述: 跳转商品列表页
	 * windows优化前QPS：1332
	 * 缓存QPS：2342
	 *
	 * @param:
	 * @return: 乐字节：专注线上IT培训
	 * 答疑老师微信：lezijie
	 * @since: 1.0.0
	 * @Author: zhoubin
	 */
	@RequestMapping(value = "/toList")
	@ResponseBody
	public String toList(HttpSession session, Model model, @CookieValue(value = "userTicket",required = false) String ticket) {
		//Redis中获取页面，如果不为空，直接返回页面
		if(StringUtils.isBlank(ticket)){
			return "login";
		}
		TUser tUser= (TUser) session.getAttribute(ticket);
		if(Objects.isNull(tUser)){
			return
					"login";
		}
		model.addAttribute("user",tUser);
		return "goodsList";
	}


}