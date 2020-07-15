package com.community.manage.exception;

import lombok.Data;

@Data
public class OtherException extends Exception {
    public String msg;
    public String tip;
    public int status;
}
