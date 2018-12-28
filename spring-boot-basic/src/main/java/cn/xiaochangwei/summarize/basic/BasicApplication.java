package cn.xiaochangwei.summarize.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * create by changw.xiao@qq.com at 2018/12/28 7:41
 **/
@ComponentScan(basePackages = {"cn.xiaochangwei.summarize.basic", "cn.xiaochangwei.summarize.common"})
@SpringBootApplication
@EnableScheduling
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
}
