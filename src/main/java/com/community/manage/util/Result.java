package com.community.manage.util;
import com.community.manage.exception.OtherException;
import lombok.Data;

@Data
public class Result<T> {
    private String msg;
    private String tip;
    private int status;
    private T data;


    //系统繁忙异常
    public static <T> Result<T> error() {
        return status(null, Status.ERROR);
    }
    //连接成功
    public static <T> Result<T> success(T data) {
        return status(data, Status.SUCCESS);
    }
    //其他异常
    public static <T> Result<T> error(Status status) {
        return status(null, status);
    }
    //其他自定义异常
    public static <T> Result<T> error(OtherException e) {
        Result<T> result = new Result<>();
        result.setMsg(e.getMsg());
        result.setTip(e.getTip());
        result.setStatus(e.getStatus());
        return result;
    }
    public static <T> Result<T> status(T data, Status status) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setMsg(status.getMsg());
        result.setTip(status.getTip());
        result.setStatus(status.getStatus());
        return result;
    }

}
