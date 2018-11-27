package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/11/23 15:20
 **/
@RestController
@RequestMapping("/rest")
@Slf4j
public class RestTemplateTestController {
    @RequestMapping(value = "/target", method = {RequestMethod.GET, RequestMethod.POST})
    public String target(@RequestParam("name") String name) throws InterruptedException {
        log.info("--------- {}", name);
        Thread.sleep(5000);
        return "hello " + name + " " + UUID.randomUUID().toString();
    }

    @GetMapping("/async")
    public Result async() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "xiaochangwei_" + UUID.randomUUID().toString());
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params, headers);

        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<String>> listenableFuture = asyncRestTemplate.postForEntity("http://127.0.0.1:9001/rest/target", requestEntity, String.class);
        listenableFuture.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("excute completed! faild: " + throwable.getMessage());
            }

            @Override
            public void onSuccess(@Nullable ResponseEntity<String> listenableFuture) {
                log.info("excute completed! success: " + listenableFuture.getBody());
            }
        });

        log.info("main method excute completed!!!");
        return new Result("completd");

    }

}
