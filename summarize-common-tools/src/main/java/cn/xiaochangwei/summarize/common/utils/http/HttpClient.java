package cn.xiaochangwei.summarize.common.utils.http;

import cn.xiaochangwei.summarize.common.exception.BusinessException;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * create by changw.xiao@qq.com at 2018/11/15 10:53
 **/
@Component(value = "xHttpClient")
public class HttpClient<T, R> implements IHttpClinet<T, R> {

    private static final RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory());

    private static final String INTERFACE_ERROR_MESSAGE = "接口调用异常";

    private static final String INTERFACE_NOT_FOUND = "接口不存在";

    private static final String DATA_FILED = "data";

    private static ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(100000);
        factory.setConnectTimeout(100000);
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
                return getFieldObject(t, rClass, filedName);
            } else {
                throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
            }
        } catch (HttpClientErrorException e) {
            throw new BusinessException(INTERFACE_NOT_FOUND + ": " + url);
        }
    }

    public <R> R postObject(String url, Object param, Class<T> tClass, Class<R> r1Class) {
        return postObject(url, param, tClass, r1Class, DATA_FILED);
    }

    @Override
    public <R> R postObject(String url, Object param, Class<T> tClass, Class<R> r1Class, String fieldName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String paramJSON;
        if (param instanceof String) {
            paramJSON = String.valueOf(param);
        } else {
            paramJSON = JSON.toJSONString(param);
        }
        HttpEntity<String> entity = new HttpEntity<>(paramJSON, headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                if (!StringUtils.isEmpty(responseEntity.getBody())) {
                    T t = JSON.parseObject(responseEntity.getBody(), tClass);
                    return getFieldObject(t, r1Class, fieldName);
                } else {
                    throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
                }
            } else {
                throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
            }
        } catch (HttpClientErrorException e) {
            throw new BusinessException(INTERFACE_NOT_FOUND + ": " + url);
        }
    }

    private <T> T getFieldObject(Object object, Class<T> tClass, String fieldName) {
        if (object != null) {
            try {
                Field dataField = object.getClass().getDeclaredField(fieldName);
                boolean isAccessible = dataField.isAccessible();
                dataField.setAccessible(true);
                T result = JSON.parseObject(JSON.toJSONString(dataField.get(object)), tClass);
                dataField.setAccessible(isAccessible);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException("no such field");
            }
        } else {
            return null;
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
                List list = getFieldObject(t, List.class, filedName);
                List<R> result = JSON.parseArray(JSON.toJSONString(list), rClass);
                return result;
            } else {
                throw new BusinessException(INTERFACE_ERROR_MESSAGE + ": " + url);
            }
        } catch (HttpClientErrorException e) {
            throw new BusinessException(INTERFACE_NOT_FOUND + ": " + url);
        }
    }
}
