package com.example.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created By ChengHao On 2020/1/21
 */
@Component
public class MyScheduled {
    /**
     * 当前任务执行结束1秒后开启另一任务
     */
    @Scheduled(fixedDelay = 1000)
    public void fixedDelay() {
        System.out.println("fixedDelay:" + new Date());
    }

    /**
     * 当前任务开始执行两秒后开启另一个定时任务
     */
    @Scheduled(fixedRate = 2000)
    public void fixedRate() {
        System.out.println("fixedRate:" + new Date());
    }

    /**
     * 首次执行的延迟时间
     */
    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void initialDelay() {
        System.out.println("initialDelay:" + new Date());
    }

    /**
     * corn表达式
     * 每分钟执行一次
     */
    @Scheduled(cron = "0 * * * * ?")
    public void cron() {
        System.out.println("cron:" + new Date());
    }
}
