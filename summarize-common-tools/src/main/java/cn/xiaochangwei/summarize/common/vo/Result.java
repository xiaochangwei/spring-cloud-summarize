package cn.xiaochangwei.summarize.common.vo;


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
