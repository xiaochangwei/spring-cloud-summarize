package cn.xiaochangwei.summarize.basic.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class TraceTest {

    @Scheduled(fixedRate = 5 * 1000)
    public void log01() {
        log.trace("trace log01 " + UUID.randomUUID().toString());
        log.debug("debug-trace log01 " + UUID.randomUUID().toString());
    }

}
