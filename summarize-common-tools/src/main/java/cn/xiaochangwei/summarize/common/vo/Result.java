package cn.xiaochangwei.summarize.common.vo;


import cn.xiaochangwei.summarize.common.exception.ErrorType;

import java.io.Serializable;

/**
 * create by changw.xiao@qq.com at 2018/10/9 15:07
 **/
public class Result<T> implements Serializable {
    public static final Integer ERROR_CODE = -1;
    private Integer status = 200;
    private T data;
    private String error;

    public Result() {

    }

    public Result(Integer status, T data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Result(T data) {
        this(200, data, null);
    }

    public Result(Integer status, String error) {
        this(status, null, error);
    }

    public static Result success() {
        return success(null);
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result fail(Integer status, String errorMessage) {
        return new Result(status, errorMessage);
    }

    public static Result fail(ErrorType type) {
        return new Result(Integer.valueOf(type.getCode()), type.getMesg());
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
