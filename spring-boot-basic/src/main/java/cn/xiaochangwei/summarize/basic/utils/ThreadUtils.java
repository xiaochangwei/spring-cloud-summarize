package cn.xiaochangwei.summarize.basic.utils;

import lombok.extern.slf4j.Slf4j;

import javax.sound.midi.Soundbank;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ThreadUtils {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(10);
        Executors.newWorkStealingPool();

        ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger(0);
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("-------------------" + atomicInteger.incrementAndGet());
//        }, 1L, 1L, TimeUnit.SECONDS);

        executorService.execute(() -> {
            log.error("*************");
        });
    }


}
