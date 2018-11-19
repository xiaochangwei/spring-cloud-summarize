package cn.xiaochangwei.summarize.common.exception;

/**
 * create by changw.xiao@qq.com at 2018/11/15 14:05
 **/
public class BusinessException extends RuntimeException {
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
