package cn.xiaochangwei.summarize.basic.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class InfoLogTest {

//    @Scheduled(fixedRate = 5 * 1000)
    public void log01() {
        log.error("info log01 " + UUID.randomUUID().toString());
    }

}
