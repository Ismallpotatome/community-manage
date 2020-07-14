package com.community.manage.util;

import com.community.manage.exception.ControllerException;
import lombok.Data;

@Data
public class Result<T> {
    private String msg;
    private String tip;
    private int status;
    private T data;


    //系统繁忙异常
    public static <T> Result<T> error() {
        return status(null, ErrorStatus.ERROR);
    }
    //连接成功
    public static <T> Result<T> success(T data) {
        return status(data, ErrorStatus.SUCCESS);
    }
    //其他异常
    public static <T> Result<T> error(ErrorStatus errorStatus) {
        return status(null, errorStatus);
    }

    public static <T> Result<T> status(T data, ErrorStatus errorStatus) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setMsg(errorStatus.getMsg());
        result.setTip(errorStatus.getTip());
        result.setStatus(errorStatus.getStatus());
        return result;
    }

}
