package com.qiandai.mapper;

import com.qiandai.entity.Activity;

public interface ActivityMapper {
    int insert(Activity record);

    int insertSelective(Activity record);
}