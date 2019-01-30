package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.single.dao.mapper.UserMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * create by changw.xiao@qq.com at 2018/11/26 9:39
 **/
@Component
public class TestController {

    @Autowired
    UserMapper userMapper;

    @Scheduled(cron = "0/3 * * * * ?")
    public void getByAccount() {
        System.err.println("******* get start ******* ");
        System.out.println(JSON.toJSONString(userMapper.findByAccount("xgg")));
        System.err.println("*******  get end ******* ");
    }

    @Scheduled(cron = "0/14 * * * * ?")
    public void deleteCache() {
        System.err.println("----clear cache start------");
        userMapper.deleteCache();
        System.err.println("----clear cache end------");
    }

}
