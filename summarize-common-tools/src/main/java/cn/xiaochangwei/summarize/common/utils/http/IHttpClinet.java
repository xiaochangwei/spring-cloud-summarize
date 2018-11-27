package cn.xiaochangwei.summarize.common.utils.http;

import java.util.List;

/**
 * create by changw.xiao@qq.com at 2018/11/15 14:11
 **/
public interface IHttpClinet<T, R> {
    <T> T getObject(String url, Class<T> tClass);

    <R> R getObject(String url, Class<T> tClass, Class<R> rClass, String fieldName);

    <R> List<R> getObjectList(String url, Class<T> tClass, Class<R> rClass, String fieldName);

    <R> R postObject(String url, Object param, Class<T> tClass, Class<R> rClass, String fieldName);
}
