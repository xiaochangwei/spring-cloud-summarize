package cn.xiaochangwei.summarize.common.utils.http;

import cn.xiaochangwei.summarize.common.exception.BusinessException;
import com.alibaba.fastjson.JSON;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * create by changw.xiao@qq.com at 2018/11/15 10:53
 **/
@Component
public class HttpClient<T, R> implements IHttpClinet<T, R> {

    private static final RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory());

    private static final String INTERFACE_ERROR_MESSAGE = "接口调用异常";

    private static final String INTERFACE_NOT_FOUND = "接口不存在";

    private static final String DATA_FILED = "data";

    private static ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(30000);
        factory.setConnectTimeout(30000);
        return factory;
    }

    public <T> T getObject(String url, Class<T> tClass) {
        try {
            ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, tClass);
            if (responseEntity.getStatusCodeValue() == 200) {
                return responseEntity.getBody();
            } else {
                throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
            }
        } catch (HttpClientErrorException e) {
            throw new BusinessException(INTERFACE_NOT_FOUND + ": " + url);
        }
    }

    public <R> R getObject(String url, Class<T> tClass, Class<R> rClass) {
        return getObject(url, tClass, rClass, DATA_FILED);
    }

    public <R> R getObject(String url, Class<T> tClass, Class<R> rClass, String filedName) {
        try {
            ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, tClass);
            if (responseEntity.getStatusCodeValue() == 200) {
                T t = responseEntity.getBody();
                if (t != null) {
                    try {
                        Field dataField = t.getClass().getDeclaredField(filedName);
                        boolean isAccessible = dataField.isAccessible();
                        dataField.setAccessible(true);
                        R result = JSON.parseObject(JSON.toJSONString(dataField.get(t)), rClass);
                        dataField.setAccessible(isAccessible);
                        return result;
                    } catch (Exception e) {
                        throw new BusinessException("no such field");
                    }
                } else {
                    return null;
                }
            } else {
                throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
            }
        } catch (HttpClientErrorException e) {
            throw new BusinessException(INTERFACE_NOT_FOUND + ": " + url);
        }
    }

    public <R> List<R> getObjectList(String url, Class<T> tClass, Class<R> rClass) {
        return getObjectList(url, tClass, rClass, DATA_FILED);
    }

    @Override
    public <R> List<R> getObjectList(String url, Class<T> tClass, Class<R> rClass, String filedName) {
        try {
            ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, tClass);
            if (responseEntity.getStatusCodeValue() == 200) {
                T t = responseEntity.getBody();
                if (t != null) {
                    try {
                        Field dataField = t.getClass().getDeclaredField(filedName);
                        boolean isAccessible = dataField.isAccessible();
                        dataField.setAccessible(true);
//                        List<R> result = (List<R>) dataField.get(t);
                        List<R> result = JSON.parseArray(JSON.toJSONString(dataField.get(t)), rClass);
                        dataField.setAccessible(isAccessible);
                        return result;
                    } catch (Exception e) {
                        throw new BusinessException("no such field");
                    }
                } else {
                    return new ArrayList<>();
                }
            } else {
                throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
            }
        } catch (HttpClientErrorException e) {
            throw new BusinessException(INTERFACE_NOT_FOUND + ": " + url);
        }
    }
}
