package com.qiandai.entity;

import java.util.Date;

public class Detailed {
    private Long id;

    private String accountNo;

    private String custno;

    private String agentno;

    private String prodcode;

    private String totalamt;

    private String rate;

    private String interest;

    private String uninterest;

    private String hisincome;

    private String date;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno == null ? null : custno.trim();
    }

    public String getAgentno() {
        return agentno;
    }

    public void setAgentno(String agentno) {
        this.agentno = agentno == null ? null : agentno.trim();
    }

    public String getProdcode() {
        return prodcode;
    }

    public void setProdcode(String prodcode) {
        this.prodcode = prodcode == null ? null : prodcode.trim();
    }

    public String getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(String totalamt) {
        this.totalamt = totalamt == null ? null : totalamt.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getUninterest() {
        return uninterest;
    }

    public void setUninterest(String uninterest) {
        this.uninterest = uninterest == null ? null : uninterest.trim();
    }

    public String getHisincome() {
        return hisincome;
    }

    public void setHisincome(String hisincome) {
        this.hisincome = hisincome == null ? null : hisincome.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
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