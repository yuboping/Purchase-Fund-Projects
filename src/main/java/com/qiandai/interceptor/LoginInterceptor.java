package com.qiandai.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qiandai.entity.SysUser;
import com.qiandai.util.config.Global;

/**
 * 
 * <p>Title:LoginInterceptor</p>
 * <p>Description:后台登录拦截器</p>
 * @author haitao5623@163.com
 * @date 2016年4月28日下午4:50:14
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	public List<String> noInterUrl;	

	public void setNoInterUrl(List<String> noInterUrl) {
		this.noInterUrl = noInterUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath()+ Global.ADMIN_PATH;
		SysUser user = (SysUser)request.getSession().getAttribute("user");
		for (String url : noInterUrl) {
			if (!uri.endsWith(url)) { 
				if (null == user) {
					response.sendRedirect(contextPath + "/login.do");
					return false;
				}				
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
