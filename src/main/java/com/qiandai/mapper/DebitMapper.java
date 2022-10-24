package com.qiandai.mapper;

import com.qiandai.entity.Debit;

public interface DebitMapper {
    int insert(Debit record);

    int insertSelective(Debit record);
}