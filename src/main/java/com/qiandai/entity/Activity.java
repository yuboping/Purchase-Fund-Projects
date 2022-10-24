package com.qiandai.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Activity {
	
    private Long id;

    private String activityNo;

    private String activityName;

    private Date activityBegintime;

    private Date activityEndtime;

    private BigDecimal todayquota;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(String activityNo) {
        this.activityNo = activityNo == null ? null : activityNo.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Date getActivityBegintime() {
        return activityBegintime;
    }

    public void setActivityBegintime(Date activityBegintime) {
        this.activityBegintime = activityBegintime;
    }

    public Date getActivityEndtime() {
        return activityEndtime;
    }

    public void setActivityEndtime(Date activityEndtime) {
        this.activityEndtime = activityEndtime;
    }

    public BigDecimal getTodayquota() {
        return todayquota;
    }

    public void setTodayquota(BigDecimal todayquota) {
        this.todayquota = todayquota;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}