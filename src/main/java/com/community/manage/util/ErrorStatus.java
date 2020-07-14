package com.community.manage.util;

import lombok.Data;


public enum ErrorStatus {
    SUCCESS("success", "连接成功", 200),
    ERROR("system error", "系统繁忙", 500),
    CONTROLLER_ERROR("controller error", "控制层异常", 400),
    SERVICE_ERROR("service error", "服务层异常", 401);

    private String msg;
    private String tip;
    private int status;

    private ErrorStatus(String msg, String tip, int status) {
        this.msg = msg;
        this.tip = tip;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
