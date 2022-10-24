package com.qiandai.mapper;

import java.util.Map;

import com.qiandai.entity.SysUser;

public interface SysUserMapper {
	
    int insert(SysUser record);

    int insertSelective(SysUser record);
    
    SysUser findByUser(Map<String,Object> params);
    
    SysUser findByEmail(Map<String,Object> params);
    
    int updateUser(SysUser record);
}