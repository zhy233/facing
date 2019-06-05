package com.zhy.facing.entity;


public class TLoginLog {

  private long tLoginLogId;
  private long tAccountId;
  private String tLoginToken;
  private long tLoginResult;
  private String tLoginTime;


  public long getTLoginLogId() {
    return tLoginLogId;
  }

  public void setTLoginLogId(long tLoginLogId) {
    this.tLoginLogId = tLoginLogId;
  }


  public long getTAccountId() {
    return tAccountId;
  }

  public void setTAccountId(long tAccountId) {
    this.tAccountId = tAccountId;
  }


  public String getTLoginToken() {
    return tLoginToken;
  }

  public void setTLoginToken(String tLoginToken) {
    this.tLoginToken = tLoginToken;
  }


  public long getTLoginResult() {
    return tLoginResult;
  }

  public void setTLoginResult(long tLoginResult) {
    this.tLoginResult = tLoginResult;
  }


  public String getTLoginTime() {
    return tLoginTime;
  }

  public void setTLoginTime(String tLoginTime) {
    this.tLoginTime = tLoginTime;
  }

}
