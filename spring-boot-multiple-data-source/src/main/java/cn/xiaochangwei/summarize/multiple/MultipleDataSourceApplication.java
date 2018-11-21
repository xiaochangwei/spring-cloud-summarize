package cn.xiaochangwei.summarize.multiple;

//import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * create by changw.xiao@qq.com at 2018/11/18 14:08
 **/

@ComponentScan(basePackages = {"cn.xiaochangwei.summarize.multiple", "cn.xiaochangwei.summarize.common"})
//@MapperScan(basePackages = {"cn.xiaochangwei.summarize.multiple.dao.mapper"})
//@EnableJpaRepositories(basePackages = {"cn.xiaochangwei.summarize.multiple.dao.repo"})
//@EntityScan(basePackages = {"cn.xiaochangwei.summarize.multiple.entity"})
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
public class MultipleDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourceApplication.class, args);
    }
}
