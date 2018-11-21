package cn.xiaochangwei.summarize.single.rpc;

import cn.xiaochangwei.summarize.common.constants.Applications;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by changw.xiao@qq.com at 2018/11/21 13:15
 **/
@FeignClient(name = Applications.APP2) //注意这里应用名字要大写，即便在yml中spring.application.name配置的值是小写
//为防止因应用名称变更造成多处维护或漏改，这里应该用全局变量进行定义
@Component //非必需注解，只是为了不在@Autowired的地方出现错误提示
public interface IMultipleDataSourceRPC {

    @RequestMapping("/feign/producer/test")
    String testCallProducerTest(@RequestParam("name") String name);
}
