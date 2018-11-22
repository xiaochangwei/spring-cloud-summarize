package cn.xiaochangwei.summarize.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
/**
 * create by changw.xiao@qq.com at 2018/11/18 14:08
 **/

//@ComponentScan(basePackages = {"cn.xiaochangwei.summarize.cloud.gateway", "cn.xiaochangwei.summarize.common"})
@SpringBootApplication
@EnableDiscoveryClient
//@EnableAutoConfiguration
//@Configuration
public class GateWayApplication {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
//        config.setParts(1);
//        return builder.routes()
//                .route("host_route", r -> r.path("/a/**").filters(f -> f.stripPrefix(1)).uri("lb://app1"))
//                .route("host_route", r -> r.path("/b/**").filters(f -> f.stripPrefix(1)).uri("lb://aPp2")) //经测试 app名称全大写、全小写、大小写混合都没关系，但是最前面的lb只能小写
//                .build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
