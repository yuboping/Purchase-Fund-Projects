package com.qiandai.back.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiandai.back.service.SysUserService;
import com.qiandai.entity.SysUser;
import com.qiandai.mapper.SysUserMapper;
import com.qiandai.util.cipher.MD5Utils;
import com.qiandai.util.config.Global;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public String saveUser(Map<String, Object> params) {
		String result = "";
		SysUser sysUser = sysUserMapper.findByEmail(params);
		if ( null != sysUser ) {
			return  "mailFail";
		} 
		String password = (String) params.get("password");
		String rpassword = (String) params.get("rpassword");

		if (password.equals(rpassword)) {
			SysUser sys = new SysUser();
			sys.setLoginName((String) params.get("username"));
			sys.setPassword(MD5Utils.md5(password));
			sys.setEmail((String) params.get("email"));
			sys.setLoginIp((String) params.get("ip"));
			int i = sysUserMapper.insert(sys);
			if (i > 0) {
				result = "success";
			} else {
				result = "fail";
			}
		}
		return result;

	}

	@Override
	public int updateUser(SysUser sysUser) {
		 return sysUserMapper.updateUser(sysUser);
	}

	@Override
	public SysUser findByUser(Map<String,Object> params) {
		String password = (String)params.get("password");
		SysUser sysUser = null;
		if ( !"null".equals(password) ) {
			params.put("password",  MD5Utils.md5(password));
			sysUser = sysUserMapper.findByUser(params);
		}
		return sysUser;
	}
	
	
}
