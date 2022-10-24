package com.qiandai.mapper;

import com.qiandai.entity.OutAccount;

public interface OutAccountMapper {
    int insert(OutAccount record);

    int insertSelective(OutAccount record);
}