package com.qiandai.mapper;

import com.qiandai.entity.SysNotice;

public interface SysNoticeMapper {
    int insert(SysNotice record);

    int insertSelective(SysNotice record);
}