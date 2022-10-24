package com.qiandai.back.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiandai.back.service.SysUserService;
import com.qiandai.entity.SysUser;
import com.qiandai.util.cipher.MD5Utils;
import com.qiandai.util.config.Global;
import com.qiandai.util.controller.BaseController;
import com.qiandai.util.sms.MailUtils;
 

@Controller
@RequestMapping(value=Global.BASIC_PATH+"/")
public class BasicController extends BaseController {
	
	@Autowired
	private SysUserService sysUserService;

	@ResponseBody
	@RequestMapping("register")
	public String register(HttpServletRequest request,HttpSession session) {
        String token = (String) session.getAttribute("token");
        String tokenValue =request.getParameter("token");
        String result="";
        if(token!=null && token.equals(tokenValue)){
        	session.removeAttribute("token");
        	 Map<String,Object> params = getParams(request);
        	 result =this.sysUserService.saveUser(params);
        }else{
        	 result ="resetSubmit";
        }
       
		return result;
	}
	
	@ResponseBody
	@RequestMapping("forgotPassword")
	public String forgotPassword(HttpServletRequest request,HttpSession session) {
		Map<String,Object> params = getParams(request);
		String to = (String) params.get("email");
		session.setAttribute("email", to);
		String subject = "找回密码";
		String content ="<html>HI，会员：<span id='email'"+to+",【保钱袋】已经收到了您的找回密码申请，请点击下面的确认链接重新设置您的登录密码：<br><a target='_blank' href='http://localhost:8080/FundServer/b/resetPassword.do'>点击这里，立即修改</a>如果该链接无效， 请直接复制以下的链接：http://localhost:8080/FundServer/b/resetPassword.do</html>";
		boolean result = MailUtils.sendToc(to,subject,content);
		String success = "fail";
		if(result){
			success = "success";
		}
		 return success ;
	}
	
	@RequestMapping("resetPassword")
	public String resetPassword(HttpServletRequest request,HttpSession session) {
		String email =(String) session.getAttribute("email");
		System.out.println(email);
		SysUser sysUser =new SysUser();
		sysUser.setEmail(email);
		sysUser.setPassword(MD5Utils.md5("time.9818"));
		int i = this.sysUserService.updateUser(sysUser);
		return "back/page/login";
	}
} 	
