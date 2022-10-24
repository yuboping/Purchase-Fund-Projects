package com.qiandai.mapper;

import com.qiandai.entity.ActivityUser;

public interface ActivityUserMapper {
    int insert(ActivityUser record);

    int insertSelective(ActivityUser record);
}