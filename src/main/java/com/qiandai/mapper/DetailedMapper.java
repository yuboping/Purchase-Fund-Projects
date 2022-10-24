package com.qiandai.mapper;

import com.qiandai.entity.Detailed;

public interface DetailedMapper {
    int insert(Detailed record);

    int insertSelective(Detailed record);
}