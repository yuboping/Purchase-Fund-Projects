package com.qiandai.mapper;

import com.qiandai.entity.IntoAccount;

public interface IntoAccountMapper {
    int insert(IntoAccount record);

    int insertSelective(IntoAccount record);
}