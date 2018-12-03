package cn.xiaochangwei.summarize.cloud.gateway.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by changw.xiao@qq.com at 2018/11/30 19:14
 **/
@RestController
@RefreshScope
public class TestController {

    @Value("${test.message:test}")
    String message;

    @GetMapping("test")
    public Result getMessage() {
        return Result.success(message);
    }
}
