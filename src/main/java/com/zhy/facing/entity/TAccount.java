package com.zhy.facing.entity;


public class TAccount {

  private long tAccountId;
  private String tAccountNo;
  private String tAccountName;
  private String tUserName;
  private String tPhone;
  private long tSex;
  private String tAccountCreateTime;
  private long tAccountStatus;


  public long getTAccountId() {
    return tAccountId;
  }

  public void setTAccountId(long tAccountId) {
    this.tAccountId = tAccountId;
  }


  public String getTAccountNo() {
    return tAccountNo;
  }

  public void setTAccountNo(String tAccountNo) {
    this.tAccountNo = tAccountNo;
  }


  public String getTAccountName() {
    return tAccountName;
  }

  public void setTAccountName(String tAccountName) {
    this.tAccountName = tAccountName;
  }


  public String getTUserName() {
    return tUserName;
  }

  public void setTUserName(String tUserName) {
    this.tUserName = tUserName;
  }


  public String getTPhone() {
    return tPhone;
  }

  public void setTPhone(String tPhone) {
    this.tPhone = tPhone;
  }


  public long getTSex() {
    return tSex;
  }

  public void setTSex(long tSex) {
    this.tSex = tSex;
  }


  public String getTAccountCreateTime() {
    return tAccountCreateTime;
  }

  public void setTAccountCreateTime(String tAccountCreateTime) {
    this.tAccountCreateTime = tAccountCreateTime;
  }


  public long getTAccountStatus() {
    return tAccountStatus;
  }

  public void setTAccountStatus(long tAccountStatus) {
    this.tAccountStatus = tAccountStatus;
  }

}
