package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * create by changw.xiao@qq.com at 2018/11/26 9:39
 **/
public class TestController {

    public Result test(Map<Object, Object> map) {
        Assert.notNull(map.get(""), "");
        return Result.success();
    }
}
