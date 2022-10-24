package com.qiandai.entity;

import java.util.Date;

public class OutAccount {
    private Long id;

    private String accountNo;

    private String custno;

    private String agentno;

    private String applydate;

    private String applytime;

    private String busiseriaion;

    private String orderid;

    private String trantype;

    private String trandate;

    private String trantime;

    private String prodcode;

    private String tranmoney;

    private String tranamt;

    private String start;

    private String transeriaion;

    private String accountState;

    private Date accountTime;

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

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate == null ? null : applydate.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime == null ? null : applytime.trim();
    }

    public String getBusiseriaion() {
        return busiseriaion;
    }

    public void setBusiseriaion(String busiseriaion) {
        this.busiseriaion = busiseriaion == null ? null : busiseriaion.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getTrantype() {
        return trantype;
    }

    public void setTrantype(String trantype) {
        this.trantype = trantype == null ? null : trantype.trim();
    }

    public String getTrandate() {
        return trandate;
    }

    public void setTrandate(String trandate) {
        this.trandate = trandate == null ? null : trandate.trim();
    }

    public String getTrantime() {
        return trantime;
    }

    public void setTrantime(String trantime) {
        this.trantime = trantime == null ? null : trantime.trim();
    }

    public String getProdcode() {
        return prodcode;
    }

    public void setProdcode(String prodcode) {
        this.prodcode = prodcode == null ? null : prodcode.trim();
    }

    public String getTranmoney() {
        return tranmoney;
    }

    public void setTranmoney(String tranmoney) {
        this.tranmoney = tranmoney == null ? null : tranmoney.trim();
    }

    public String getTranamt() {
        return tranamt;
    }

    public void setTranamt(String tranamt) {
        this.tranamt = tranamt == null ? null : tranamt.trim();
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getTranseriaion() {
        return transeriaion;
    }

    public void setTranseriaion(String transeriaion) {
        this.transeriaion = transeriaion == null ? null : transeriaion.trim();
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState == null ? null : accountState.trim();
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
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