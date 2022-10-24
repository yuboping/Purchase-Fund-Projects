package com.qiandai.mapper;

import com.qiandai.entity.BuyOrders;

public interface BuyOrdersMapper {
    int insert(BuyOrders record);

    int insertSelective(BuyOrders record);
}