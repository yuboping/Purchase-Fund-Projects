package com.qiandai.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyOrders {
    private Long id;

    private String buyNo;

    private String userNo;

    private String buyChannel;

    private String custNo;

    private String agentNo;

    private String custName;

    private String idType;

    private String idCode;

    private String mobileNo;

    private BigDecimal tranAmt;

    private String prodCode;

    private String acctNo;

    private String openBank;

    private BigDecimal balanceAmt;

    private String capitalStatus;

    private String processFlag;

    private String userbankcardNo;

    private String activityNo;

    private String buyState;

    private String buyInfo;

    private String buyTime;

    private String refundState;

    private String refundTime;

    private String debitState;

    private Date debitTime;

    private String debitTaskNo;

    private String debitTaskState;

    private String buyTaskNo;

    private String buyTaskState;

    private String reconciliationState;

    private String seqNo;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String buySource;

    private String fundplayState;

    private Date fundplayTime;

    private String fundplayNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyNo() {
        return buyNo;
    }

    public void setBuyNo(String buyNo) {
        this.buyNo = buyNo == null ? null : buyNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getBuyChannel() {
        return buyChannel;
    }

    public void setBuyChannel(String buyChannel) {
        this.buyChannel = buyChannel == null ? null : buyChannel.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo == null ? null : agentNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode == null ? null : prodCode.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public String getCapitalStatus() {
        return capitalStatus;
    }

    public void setCapitalStatus(String capitalStatus) {
        this.capitalStatus = capitalStatus == null ? null : capitalStatus.trim();
    }

    public String getProcessFlag() {
        return processFlag;
    }

    public void setProcessFlag(String processFlag) {
        this.processFlag = processFlag == null ? null : processFlag.trim();
    }

    public String getUserbankcardNo() {
        return userbankcardNo;
    }

    public void setUserbankcardNo(String userbankcardNo) {
        this.userbankcardNo = userbankcardNo == null ? null : userbankcardNo.trim();
    }

    public String getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(String activityNo) {
        this.activityNo = activityNo == null ? null : activityNo.trim();
    }

    public String getBuyState() {
        return buyState;
    }

    public void setBuyState(String buyState) {
        this.buyState = buyState == null ? null : buyState.trim();
    }

    public String getBuyInfo() {
        return buyInfo;
    }

    public void setBuyInfo(String buyInfo) {
        this.buyInfo = buyInfo == null ? null : buyInfo.trim();
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime == null ? null : buyTime.trim();
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState == null ? null : refundState.trim();
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime == null ? null : refundTime.trim();
    }

    public String getDebitState() {
        return debitState;
    }

    public void setDebitState(String debitState) {
        this.debitState = debitState == null ? null : debitState.trim();
    }

    public Date getDebitTime() {
        return debitTime;
    }

    public void setDebitTime(Date debitTime) {
        this.debitTime = debitTime;
    }

    public String getDebitTaskNo() {
        return debitTaskNo;
    }

    public void setDebitTaskNo(String debitTaskNo) {
        this.debitTaskNo = debitTaskNo == null ? null : debitTaskNo.trim();
    }

    public String getDebitTaskState() {
        return debitTaskState;
    }

    public void setDebitTaskState(String debitTaskState) {
        this.debitTaskState = debitTaskState == null ? null : debitTaskState.trim();
    }

    public String getBuyTaskNo() {
        return buyTaskNo;
    }

    public void setBuyTaskNo(String buyTaskNo) {
        this.buyTaskNo = buyTaskNo == null ? null : buyTaskNo.trim();
    }

    public String getBuyTaskState() {
        return buyTaskState;
    }

    public void setBuyTaskState(String buyTaskState) {
        this.buyTaskState = buyTaskState == null ? null : buyTaskState.trim();
    }

    public String getReconciliationState() {
        return reconciliationState;
    }

    public void setReconciliationState(String reconciliationState) {
        this.reconciliationState = reconciliationState == null ? null : reconciliationState.trim();
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
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

    public String getBuySource() {
        return buySource;
    }

    public void setBuySource(String buySource) {
        this.buySource = buySource == null ? null : buySource.trim();
    }

    public String getFundplayState() {
        return fundplayState;
    }

    public void setFundplayState(String fundplayState) {
        this.fundplayState = fundplayState == null ? null : fundplayState.trim();
    }

    public Date getFundplayTime() {
        return fundplayTime;
    }

    public void setFundplayTime(Date fundplayTime) {
        this.fundplayTime = fundplayTime;
    }

    public String getFundplayNo() {
        return fundplayNo;
    }

    public void setFundplayNo(String fundplayNo) {
        this.fundplayNo = fundplayNo == null ? null : fundplayNo.trim();
    }
}