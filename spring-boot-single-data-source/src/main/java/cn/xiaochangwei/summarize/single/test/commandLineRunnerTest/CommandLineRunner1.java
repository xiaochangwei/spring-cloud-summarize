package cn.xiaochangwei.summarize.single.test.commandLineRunnerTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * create by changw.xiao@qq.com at 2018/11/22 18:34
 **/
@Component
@Slf4j
@Order(value = 88)
public class CommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner1 is running...");
//        int i = 8 / 0;
        log.info("CommandLineRunner1 stopped");
    }
}
