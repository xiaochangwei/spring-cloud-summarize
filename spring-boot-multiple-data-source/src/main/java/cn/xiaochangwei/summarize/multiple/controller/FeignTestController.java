package cn.xiaochangwei.summarize.multiple.controller;

import org.springframework.web.bind.annotation.*;

/**
 * create by changw.xiao@qq.com at 2018/11/21 14:00
 **/
@RestController
@RequestMapping("/feign")
public class FeignTestController {

    @RequestMapping(value = "/producer/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String producerTest(@RequestParam("name") String name) {
//       修改下面信息，打包多个启动注册到eureka后，通过app1 feign调用，会发现是轮训方式调用服务接口
//        return "hello " + name + ", producer-01 is ready";
        return "hello " + name + ", producer-02 is ready";
    }
}
