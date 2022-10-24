package com.qiandai.mapper;

import com.qiandai.entity.Channels;

public interface ChannelsMapper {
    int insert(Channels record);

    int insertSelective(Channels record);
}