package com.qiandai.mapper;

import com.qiandai.entity.SysBanner;

public interface SysBannerMapper {
    int insert(SysBanner record);

    int insertSelective(SysBanner record);
}