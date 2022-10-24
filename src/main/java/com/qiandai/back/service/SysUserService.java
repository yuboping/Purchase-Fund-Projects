package com.qiandai.back.service;

import java.util.Map;

import com.qiandai.entity.SysUser;

public interface SysUserService {
	
	String saveUser(Map<String,Object> params);
	
	int updateUser(SysUser sysUser);
	
	SysUser findByUser(Map<String,Object> params);
	
	
}
