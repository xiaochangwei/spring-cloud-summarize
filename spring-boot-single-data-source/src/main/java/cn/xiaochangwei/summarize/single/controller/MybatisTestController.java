package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.single.dao.mapper.UserMapper;
import cn.xiaochangwei.summarize.single.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/11/19 15:42
 **/
@RestController
@RequestMapping("/mybatis")
public class MybatisTestController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/query")
    public Result mybatisTest(User user) {
        userMapper.findByAccount(user.getAccount());
        userMapper.findByCondition(user);
        return new Result(userMapper.findByCondition(user));
    }

    @GetMapping("/trasactional")
    @Transactional //@Transactional(rollbackFor = RuntimeException.class) //默认是RuntimeException异常时才回滚
    //    @Transactional(rollbackFor = Exception.class) //非RuntimeException异常时指明对应异常类型
    public Result trasactional() {
        userMapper.updatePassword(UUID.randomUUID().toString(), 1L);
        int i = 8 / 0;
        return new Result(null);
    }
}
