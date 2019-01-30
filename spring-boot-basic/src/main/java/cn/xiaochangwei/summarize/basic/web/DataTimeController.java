package cn.xiaochangwei.summarize.basic.web;

import cn.xiaochangwei.summarize.basic.entity.User;
import cn.xiaochangwei.summarize.common.vo.Result;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@RestController
public class DataTimeController {

    @PostMapping("/date")
    public Result dateTest(User user) {
        System.out.println(1000);
        System.out.println(1001);
        System.out.println(1002);
        System.out.println(1003);
        System.out.println(1004);
        return Result.success(user);
    }
}
