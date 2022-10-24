package com.qiandai.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FundPlay {
    private Long id;

    private String playNo;

    private String playName;

    private String cardNo;

    private BigDecimal playMoney;

    private String mobileNo;

    private String playState;

    private String playTime;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayNo() {
        return playNo;
    }

    public void setPlayNo(String playNo) {
        this.playNo = playNo == null ? null : playNo.trim();
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName == null ? null : playName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public BigDecimal getPlayMoney() {
        return playMoney;
    }

    public void setPlayMoney(BigDecimal playMoney) {
        this.playMoney = playMoney;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getPlayState() {
        return playState;
    }

    public void setPlayState(String playState) {
        this.playState = playState == null ? null : playState.trim();
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime == null ? null : playTime.trim();
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