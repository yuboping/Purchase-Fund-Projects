package com.qiandai.entity;

public class BanksBase {
    private String id;

    private String binno;

    private String cardlen;

    private String bankname;

    private String cardtypename;

    private String cardname;

    private String bankno;

    private String createtime;

    private String remark;

    private String cardtype;

    private String binlen;

    private String banktruename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBinno() {
        return binno;
    }

    public void setBinno(String binno) {
        this.binno = binno == null ? null : binno.trim();
    }

    public String getCardlen() {
        return cardlen;
    }

    public void setCardlen(String cardlen) {
        this.cardlen = cardlen == null ? null : cardlen.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getCardtypename() {
        return cardtypename;
    }

    public void setCardtypename(String cardtypename) {
        this.cardtypename = cardtypename == null ? null : cardtypename.trim();
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname == null ? null : cardname.trim();
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getBinlen() {
        return binlen;
    }

    public void setBinlen(String binlen) {
        this.binlen = binlen == null ? null : binlen.trim();
    }

    public String getBanktruename() {
        return banktruename;
    }

    public void setBanktruename(String banktruename) {
        this.banktruename = banktruename == null ? null : banktruename.trim();
    }
}