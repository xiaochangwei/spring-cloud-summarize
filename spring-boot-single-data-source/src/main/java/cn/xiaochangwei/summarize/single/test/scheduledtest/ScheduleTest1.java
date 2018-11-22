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
@Order(value = 2)
public class ScheduleTest1 {

    //经测试，@Scheduled在项目启动时会执行一次，如果执行中报错不影响项目正常启动，且多个任务之间(同一个类或非同一个类中)通过@Order去改变顺序没实际影响
    @Scheduled(fixedRate = 10* 60 * 1000)
    @Order(value = 20)
    public void scheduleTask() {
        log.info("scheduleTask begin running...");
        int i = 8 / 0;
        log.info("scheduleTask stopped");
    }

    @Scheduled(fixedRate = 60 * 1000)
    @Order(value = 19)
    public void scheduleTask3() {
        log.info("scheduleTask3 begin running...");
        int i = 8 / 0;
        log.info("scheduleTask3 stopped");
    }
}
