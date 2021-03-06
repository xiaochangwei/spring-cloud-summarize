package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.single.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

//import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration; //RedisAutoConfiguration已经默认实现了两个，满足日常使用了

/**
 * create by changw.xiao@qq.com at 2018/11/19 16:08
 **/
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisTestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/key")
    public Result key() {
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent("key", "v1", 3, TimeUnit.SECONDS);
        return Result.success(result);
    }

    @GetMapping("/test")
    public Result redisTest() {
        stringRedisTemplate.opsForList().leftPush("str", UUID.randomUUID().toString());
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setAccount(UUID.randomUUID().toString());
            redisTemplate.opsForList().leftPush("userList", user);
            log.info("size {}", redisTemplate.opsForList().size("userList"));
        }
        return new Result(redisTemplate.opsForList().range("userList", 0, Integer.MAX_VALUE));
    }

    @GetMapping("/test2")
    public Result redisTestKey() {
        stringRedisTemplate.opsForValue().set("test.key1.key2.key3", UUID.randomUUID().toString());
        return new Result();
    }

    @GetMapping("/test3")
    public Result redisTestKey3() {
        stringRedisTemplate.opsForValue().set("中文key", UUID.randomUUID().toString());
        return new Result();
    }


}
