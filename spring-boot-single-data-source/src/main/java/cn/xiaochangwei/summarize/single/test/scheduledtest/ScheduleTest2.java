package cn.xiaochangwei.summarize.single.test.scheduledtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * create by changw.xiao@qq.com at 2018/11/22 18:20
 **/
@Component
@Slf4j
@Order(value = 1)
public class ScheduleTest2 {

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void scheduleTask() {
        log.info("scheduleTask2 begin running...");
        int i = 8 / 0;
        log.info("scheduleTask2 stopped");

    }
}
