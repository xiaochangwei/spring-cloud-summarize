package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.single.rpc.IMultipleDataSourceRPC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by changw.xiao@qq.com at 2018/11/21 13:18
 **/
@RestController
@RequestMapping("/feign")
@Slf4j
public class FeignTestController {

    @Autowired
    IMultipleDataSourceRPC iMultipleDataSourceRPC;

    @GetMapping("/consumer/test")
    public Result feignTest() {
        return new Result(iMultipleDataSourceRPC.testCallProducerTest("changw.xiao@qq.com"));
    }
}
