package com.qiandai.util.controller;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(BaseController.class);

	public Map<String, Object> getParams(HttpServletRequest request) {
		Map<String, String[]> reqMap = request.getParameterMap();
		// 将POST表单参数转换成普通key-value对
		Map<String, Object> resultMap = new HashMap<String, Object>(0);
		resultMap.putAll(getIpAddr(request));
		for (Entry<String, String[]> m : reqMap.entrySet()) {
			String key = m.getKey();
			Object[] obj = (Object[]) reqMap.get(key);
			resultMap.put(key, (obj.length > 1) ? obj : obj[0]);
		}
		return resultMap;
	}

	public Map<String, Object> iPLocal() {
		Map<String, Object> params = new HashMap<String, Object>();
		InetAddress ia;
		try {
			ia = InetAddress.getLocalHost();
			params.put("localIp", ia.getHostAddress());
			params.put("ipN", ia.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			logger.error("ip error:" + e.getMessage());
		}
		return params;
	}

	public Map<String, Object> getIpAddr(HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		params.put("ip", ip);
		return params;
	}

	public static String downLoad(String fileName) {
		String downloadPath = "/src/main/webapp/download/";
		URL url = BaseController.class.getClass().getResource("/");
		String path = "";
		if (null == url) {
			path = BaseController.class.getClassLoader().getResource("/")
					.getPath().substring(1);
			// path =
			// CmbcUtil.class.getClassLoader().getResource("/").getFile();
		} else {
			path = url.getPath().substring(1);
			// path = url.getFile();
		}
		for (int i = 0; i < 3; i++) {
			path = path.substring(0, path.lastIndexOf("/"));
		}
		try {
			path = java.net.URLDecoder.decode(path, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		path = path + downloadPath + fileName;
		System.out.println(path);
		return path;
	}
}
