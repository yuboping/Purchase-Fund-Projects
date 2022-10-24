package com.qiandai.mapper;

import com.qiandai.entity.BanksBase;

public interface BanksBaseMapper {
    int insert(BanksBase record);

    int insertSelective(BanksBase record);
}