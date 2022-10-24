package com.qiandai.mapper;

import com.qiandai.entity.Bankcards;

public interface BankcardsMapper {
    int insert(Bankcards record);

    int insertSelective(Bankcards record);
}