package com.qiandai.mapper;

import com.qiandai.entity.FundRates;

public interface FundRatesMapper {
    int insert(FundRates record);

    int insertSelective(FundRates record);
}