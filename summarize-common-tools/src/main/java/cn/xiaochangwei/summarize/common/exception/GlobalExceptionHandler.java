package cn.xiaochangwei.summarize.common.exception;

import cn.xiaochangwei.summarize.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * create by changw.xiao@qq.com at 2018/11/13 14:08
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result defaultErrorHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        log.error(request.getRequestURI());
        String errorMsg = "";
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            for (FieldError fieldError : bindException.getFieldErrors()) {
                errorMsg += fieldError.getField() + fieldError.getDefaultMessage() + "  ";
            }
        } else if (e instanceof BadSqlGrammarException) {
            BadSqlGrammarException mySQLSyntaxErrorException = (BadSqlGrammarException) e;
            errorMsg = "执行sql出错：" + mySQLSyntaxErrorException.getMessage();
        } else if (e instanceof NoHandlerFoundException) {
            NoHandlerFoundException noHandlerFoundException = (NoHandlerFoundException) e;
            errorMsg = noHandlerFoundException.getMessage();
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException = (HttpRequestMethodNotSupportedException) e;
            errorMsg = httpRequestMethodNotSupportedException.getMessage();
        } else if (e instanceof ResourceAccessException) {
            ResourceAccessException resourceAccessException = (ResourceAccessException) e;
            errorMsg = resourceAccessException.getMessage();
        } else if (e instanceof NullPointerException) {
            errorMsg = "空指针异常，请增加逻辑判断";
        } else if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            errorMsg = businessException.getMessage();
        }

        //TODO 根据业务增加相关异常捕获
        return new Result(-1, StringUtils.isEmpty(errorMsg) ? e.getMessage() : errorMsg);
    }
}
