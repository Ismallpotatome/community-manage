package com.community.manage.exception;

import com.community.manage.util.ErrorStatus;

public class ControllerException extends Exception {
    private String msg;
    private String tip;
    private int status;

    public ControllerException(String msg, String tip, int status) {
        this.msg = msg;
        this.tip = tip;
        this.status = status;
    }
    public ControllerException(ErrorStatus errorStatus) {
        this.msg = errorStatus.getMsg();
        this.tip = errorStatus.getTip();
        this.status = errorStatus.getStatus();
    }
}
