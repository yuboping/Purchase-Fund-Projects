package com.qiandai.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DebitThird {
    private Long id;

    private String debitNo;

    private String merchantcode;

    private String orderNo;

    private BigDecimal money;

    private String operator;

    private String remarks;

    private String typededuction;

    private String applyresult;

    private String applyresultdescription;

    private String applytime;

    private String buyresult;

    private String buyresultdescription;

    private String debitresult;

    private String debitresultdescription;

    private String debittime;

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

    public String getMerchantcode() {
        return merchantcode;
    }

    public void setMerchantcode(String merchantcode) {
        this.merchantcode = merchantcode == null ? null : merchantcode.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getTypededuction() {
        return typededuction;
    }

    public void setTypededuction(String typededuction) {
        this.typededuction = typededuction == null ? null : typededuction.trim();
    }

    public String getApplyresult() {
        return applyresult;
    }

    public void setApplyresult(String applyresult) {
        this.applyresult = applyresult == null ? null : applyresult.trim();
    }

    public String getApplyresultdescription() {
        return applyresultdescription;
    }

    public void setApplyresultdescription(String applyresultdescription) {
        this.applyresultdescription = applyresultdescription == null ? null : applyresultdescription.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime == null ? null : applytime.trim();
    }

    public String getBuyresult() {
        return buyresult;
    }

    public void setBuyresult(String buyresult) {
        this.buyresult = buyresult == null ? null : buyresult.trim();
    }

    public String getBuyresultdescription() {
        return buyresultdescription;
    }

    public void setBuyresultdescription(String buyresultdescription) {
        this.buyresultdescription = buyresultdescription == null ? null : buyresultdescription.trim();
    }

    public String getDebitresult() {
        return debitresult;
    }

    public void setDebitresult(String debitresult) {
        this.debitresult = debitresult == null ? null : debitresult.trim();
    }

    public String getDebitresultdescription() {
        return debitresultdescription;
    }

    public void setDebitresultdescription(String debitresultdescription) {
        this.debitresultdescription = debitresultdescription == null ? null : debitresultdescription.trim();
    }

    public String getDebittime() {
        return debittime;
    }

    public void setDebittime(String debittime) {
        this.debittime = debittime == null ? null : debittime.trim();
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