package cn.xiaochangwei.summarize.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * create by changw.xiao@qq.com at 2018/12/26 14:08
 **/
@ComponentScan(basePackages = {"cn.xiaochangwei.summarize.mq", "cn.xiaochangwei.summarize.common"})
@SpringBootApplication
@EnableScheduling
public class MQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class, args);
    }
}
