package com.zhy.facing.common.domain;

public enum StatusEnum {
    PARAM_ERROR(1001,"参数错误"),
    WEB_ERROR(1002,"网络不稳定,请稍后再试");

    private Integer code;
    private String mssage;

    StatusEnum(Integer code, String mssage) {
        this.code = code;
        this.mssage = mssage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMssage() {
        return mssage;
    }

    public void setMssage(String mssage) {
        this.mssage = mssage;
    }
}
