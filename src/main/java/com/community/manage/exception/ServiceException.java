package com.community.manage.exception;

import com.community.manage.util.Status;

public class ServiceException extends OtherException {
    public ServiceException(String msg, String tip, int status) {
        this.msg = msg;
        this.tip = tip;
        this.status = status;
    }
    public ServiceException(Status status) {
        this.msg = status.getMsg();
        this.tip = status.getTip();
        this.status = status.getStatus();
    }
}
