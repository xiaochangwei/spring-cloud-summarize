package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.single.entity.User;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * create by changw.xiao@qq.com at 2018/11/19 10:32
 **/
@RestController
@Slf4j
@RequestMapping("/internationalization")
@Api(tags = {"参数验证及信息国际化"})
public class InternationalizationController {

    @GetMapping("/param/valid")
    @ApiOperation(value = "验证及国际化提示，设置header的Accept-Language参数")
    public Result paramValid(@Valid User user) {
        return new Result(user);
    }
}
