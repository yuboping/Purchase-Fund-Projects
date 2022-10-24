package com.qiandai.mapper;

import com.qiandai.entity.BankSupport;

public interface BankSupportMapper {
    int insert(BankSupport record);

    int insertSelective(BankSupport record);
}