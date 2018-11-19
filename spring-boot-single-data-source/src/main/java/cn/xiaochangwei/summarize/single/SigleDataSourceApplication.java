package cn.xiaochangwei.summarize.single;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * create by changw.xiao@qq.com at 2018/11/18 14:08
 **/

@ComponentScan(basePackages = {"cn.xiaochangwei.summarize.single", "cn.xiaochangwei.summarize.common"})
@MapperScan(basePackages = {"cn.xiaochangwei.summarize.single.dao.mapper"})
//@EnableJpaRepositories(basePackages = {"cn.xiaochangwei.summarize.single.dao.repo"})
//@EntityScan(basePackages = {"cn.xiaochangwei.summarize.single.entity"})
@SpringBootApplication
@EnableSwagger2
public class SigleDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigleDataSourceApplication.class, args);
    }
}
