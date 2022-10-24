package com.qiandai.back.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qiandai.back.service.SysUserService;
import com.qiandai.entity.SysUser;
import com.qiandai.util.config.Global;
import com.qiandai.util.controller.BaseController;

@Controller
@RequestMapping(value=Global.ADMIN_PATH+"/")
public class HomeController extends BaseController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		Map<String,Object> params = getParams(request);
		SysUser sysUser = sysUserService.findByUser(params);
		if ( null != sysUser ) {
			request.getSession().setAttribute("user", sysUser);
			return "redirect:"+Global.ADMIN_PATH+"/index.do";
		} 
		//ModelAndView  model = ModelAndView("");
		return "back/page/login";
	}
	
	
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		
		return "back/page/index";
	}
	
	@ResponseBody
	@RequestMapping("register")
	public String register(HttpServletRequest request) {
		Map<String,Object> params = getParams(request);
		return this.sysUserService.saveUser(params);
	}
} 	
