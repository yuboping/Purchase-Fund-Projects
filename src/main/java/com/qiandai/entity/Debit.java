package com.qiandai.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Debit {
    private Long id;

    private String debitNo;

    private String orderno;

    private String ordersource;

    private String name;

    private String cardType;

    private String cardNo;

    private String mobileNo;

    private BigDecimal debitMoney;

    private String debitCode;

    private String debitStatus;

    private Date debitTime;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDebitNo() {
        return debitNo;
    }

    public void setDebitNo(String debitNo) {
        this.debitNo = debitNo == null ? null : debitNo.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getOrdersource() {
        return ordersource;
    }

    public void setOrdersource(String ordersource) {
        this.ordersource = ordersource == null ? null : ordersource.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public BigDecimal getDebitMoney() {
        return debitMoney;
    }

    public void setDebitMoney(BigDecimal debitMoney) {
        this.debitMoney = debitMoney;
    }

    public String getDebitCode() {
        return debitCode;
    }

    public void setDebitCode(String debitCode) {
        this.debitCode = debitCode == null ? null : debitCode.trim();
    }

    public String getDebitStatus() {
        return debitStatus;
    }

    public void setDebitStatus(String debitStatus) {
        this.debitStatus = debitStatus == null ? null : debitStatus.trim();
    }

    public Date getDebitTime() {
        return debitTime;
    }

    public void setDebitTime(Date debitTime) {
        this.debitTime = debitTime;
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